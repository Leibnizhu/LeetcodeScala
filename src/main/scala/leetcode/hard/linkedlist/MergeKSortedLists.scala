package leetcode.hard.linkedlist

import leetcode.common.ListNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/134/
  *
  * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
  */
object MergeKSortedLists {
  /**
    * 之前在leetcode.primary.linkedlist.MergeTwoLists做过两个排序链表的合并,需要O(2n)时间
    * 合并K个链表,直接一个个合并,需要O(2n+3n+...+kn)时间,约为O(n*k^2)
    * 如果两个两个合并,比如k=4,先合并1和2得到1',再合并3和4得到3',最后合并1'和3',需要时间2n+2n+4n
    * k=pow(2,m)时需要时间 O(2^m-1*2^1*n +  2^m-2*2^2*n +...+ 2^1*2^m-1*n)
    * =O(2^m*n +2^m*n +...2^m*n) = O(n*k*logk), 比O(n*k^2)小
    */
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    val k = lists.length
    if (k == 0) {
      null
    } else if (k == 1) {
      lists(0)
    } else if (k == 2) {
      mergeTwoLists(lists(0), lists(1))
    } else {
      val mid = k / 2
      val (left, right) = lists.splitAt(mid)
      val leftRoot = mergeKLists(left)
      val rightRoot = mergeKLists(right)
      mergeTwoLists(leftRoot, rightRoot)
    }
  }

  private def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
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
