package leetcode.hard.design

import scala.collection.mutable

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/61/design/160/
  *
  * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
  * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
  * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
  * 进阶:
  *  - 你是否可以在 O(1) 时间复杂度内完成这两种操作？
  */
class LRUCache(_capacity: Int) {
  /**
    * 关键在于get和put的时候都要维护key在最前面,那么除了Map,还要至少维护一个key的List
    * 考虑到需要O(1)时间完成操作,至少有以下操作:
    * 指定节点移到表头(被访问时),删除最后一个节点(缓存满时),插入到表头(第一次put时)
    * 那么应该选择双向链表,顺手实现一个吧
    */
  val map = new mutable.HashMap[Int, Node]()
  val lastVisit = new CacheNodeList

  def get(key: Int): Int = map.get(key) match {
      case Some(node) => lastVisit.moveToFirst(node).value //节点被访问,移到表头
      case None => -1
    }

  def put(key: Int, value: Int): Unit = map.get(key) match {
      case Some(node) => //key已存在
        node.value = value //更新值
        lastVisit.moveToFirst(node) //节点被访问,移到表头
      case None => //key不存在
        if (map.size == _capacity) map.remove(lastVisit.removeLast().key) //缓存满,移除最少访问的
        map.put(key, lastVisit.insertToFirst(Node(key, value)))
    }

  //双向链表的节点
  case class Node(key: Int, var value: Int, var next: Node = null, var prev: Node = null)

  class CacheNodeList {
    var head = Node(0, 0) //表头
    var tail = Node(0, 0) //表尾
    head.next = tail
    tail.prev = head

    //插入到表头(第一次put时,移动节点到表头也会复用)
    def insertToFirst(p: Node): Node = {
      //p和表头连接
      p.next = head.next
      p.prev = head
      //表头和原来的第一个元素断开连接
      head.next.prev = p
      head.next = p
      p
    }

    //删除最后一个节点(缓存满时)
    def removeLast(): Node = {
      val last = tail.prev
      last.prev.next = tail
      tail.prev = last.prev
      last
    }

    //指定节点移到表头(被访问时)
    def moveToFirst(p: Node): Node = {
      p.prev.next = p.next
      p.next.prev = p.prev
      insertToFirst(p)
    }
  }
}
