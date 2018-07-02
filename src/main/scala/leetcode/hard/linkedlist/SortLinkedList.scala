package leetcode.hard.linkedlist

import leetcode.common.ListNode

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/135/
  *
  * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
  */
object SortLinkedList {
  /**
    * 因为链表特性,交换比较麻烦,同时考虑到常数空间复杂度,可以用归并排序
    * 可以直接用之前的合并方法
    * 而查找中间值可以用快慢指针法
    */
  def sortList(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      val middle = findMiddle(head) //这里要记录下来,一会儿要置next为null,保证切断链表
      val rightHead = middle.next //切分后右边链表表头
      middle.next = null //拆分链表
      mergeTwoLists(sortList(head), sortList(rightHead))
    }
  }

  private def findMiddle(head: ListNode): ListNode = {
    if (head == null) {
      null
    } else {
      var slow = head
      var fast = head.next
      while (fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
      }
      slow
    }
  }

  /**
    * 安排序合并两个链表
    * 考虑到前面已经用到递归,而这里不好搞成尾递归,所以还是改成迭代的写法吧
    */
  private def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val dummy = ListNode(Int.MaxValue)
    var (pFinal, p1, p2) = (dummy, l1, l2) //三个游标
    while (p1 != null && p2 != null) {
      //两个表头较小者作为新表头
      if (p1.x <= p2.x) {
        pFinal.next = p1
        p1 = p1.next
      } else {
        pFinal.next = p2
        p2 = p2.next
      }
      pFinal = pFinal.next
    }
    pFinal.next = if (p1 == null) p2 else p1
    dummy.next
  }
}
