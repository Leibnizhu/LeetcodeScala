package leetcode.common

case class ListNode(var x: Int, var next: ListNode)
object ListNode {
  /**
    * 根据传入参数构造链表
    * @param nodes 节点数值的数组
    * @param len 长度
    * @param cycle 是否首尾相连(环判定用)
    * @return 头节点
    */
  def makeLinkedList(nodes: Array[Int], len: Int, cycle: Boolean = false): ListNode = {
    if (len == 0) {
      null
    } else {
      val nodeList = new Array[ListNode](len)
      nodeList(len - 1) = ListNode(nodes.last, null)
      for (i <- len - 2 to 0 by -1) {
        nodeList(i) = ListNode(nodes(i), nodeList(i + 1))
      }
      if (cycle) nodeList(len - 1).next = nodeList(0)
      nodeList(0)
    }
  }

  /**
    * 将链表按顺序还原为数组
    *
    * @param newList 链表表头
    * @param len 长度
    * @return 节点数值的数组
    */
  def linkedListToArray(newList: ListNode, len: Int): Array[Int] = {
    var cur = newList
    val result = new Array[Int](len)
    var i = 0
    while (cur != null) {
      result(i) = cur.x
      i += 1
      cur = cur.next
    }
    result
  }
}
