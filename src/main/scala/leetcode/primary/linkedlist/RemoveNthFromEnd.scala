package leetcode.primary.linkedlist

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
  *
  * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
  * 说明：给定的 n 保证是有效的。
  * 进阶：你能尝试使用一趟扫描实现吗？
  */
object RemoveNthFromEnd {
  /**
    * 要求走一趟O(n),可以用双游标,一个先走n步,然后两个同时走,快的到尾部慢的就删掉
    *
    * @param head 链表头
    * @param n    删除倒数第n个节点
    * @return 头节点,因为如果删除头结点,那么头结点也删掉了
    */
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var front = head
    var back = head
    //前游标先走n步
    for (_ <- 0 until n) front = front.next
    if (front == null) {
      //前面已经走到队尾
      head.next
    } else {
      //前后游标一起走
      while (front.next != null) {
        front = front.next
        back = back.next
      }
      //删除后游标对应的节点
      back.next = back.next.next
      head
    }
  }

}
