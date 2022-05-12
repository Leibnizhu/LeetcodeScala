package leetcode.medium.linkedlist

import leetcode.common.ListNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/82/
  *
  * 给定两个非空链表来表示两个非负整数。位数按照[逆序]方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
  * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
  */
object AddTwoNumbers {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var p1 = l1
    var p2 = l2
    var carry = 0 //进位,因为是逆序的，每一位相加的进位给下一位处理就行
    var root: ListNode = null //链表表头，用于返回
    var prev: ListNode = null //上一个节点
    while (p1 != null || p2 != null) { //只要还有一个不为空就继续，减少后面处理的代码
      val sum = Option(p1).map(_.x).getOrElse(0) + Option(p2).map(_.x).getOrElse(0) + carry
      carry = sum / 10
      val cur = ListNode(sum % 10)
      if (p1 == l1) //第一次处理，需要设置表头，用于返回
        root = cur
      else
        prev.next = cur //设置上个节点的next
      prev = cur
      if (p1 != null) p1 = p1.next
      if (p2 != null) p2 = p2.next
    }
    if(carry > 0) //处理最后的进位
      prev.next =  ListNode(carry)
    root
  }
}
