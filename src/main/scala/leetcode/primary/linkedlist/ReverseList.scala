package leetcode.primary.linkedlist

/**
  * 反转一个单链表。
  * 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
  */
object ReverseList {
  /**
    * 递归调用
    * 链表分为head::tail,递归调用reverseList翻转tail, 再把head和tail的关系倒转
    * @param head 头结点
    * @return 翻转后的头结点
    */
  def reverseList(head: ListNode): ListNode = {
    if(head == null || head.next == null){
      //空表或单节点表
      head
    } else {
      val tail = head.next // tail的头结点
      head.next = null //原头变新尾
      val newHead = reverseList(tail) //递归翻转tail链表
      tail.next = head//翻转后的tail接上原来的头
      newHead
    }
  }

  case class ListNode(var x: Int, var next: ListNode)

}
