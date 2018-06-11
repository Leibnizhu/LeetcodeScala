package leetcode.primary.linkedlist

import leetcode.common.ListNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/44/
  *
  * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
  */
object MergeTwoLists {
  /**
    * 用递归,先判断特殊情况
    * 就是一个表为空则返回另一个表
    * 然后普遍情况就是两个表头相比,较小的作为新头;
    * 剩余的两个链表继续递归调用合并,新头和合并后的链表相接,返回新头
    *
    * @param l1 第一个有序链表头
    * @param l2 第二个有序链表头
    * @return 合并后的有序链表头
    */
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null) {
      l2
    } else if (l2 == null) {
      l1
    } else {
      //两个表头较小者作为新表头,同时递归调用合并
      val (newHead, tailHead) = if (l1.x >= l2.x) (l2, mergeTwoLists(l1, l2.next)) else (l1, mergeTwoLists(l1.next, l2))
      newHead.next = tailHead
      newHead
    }
  }
}
