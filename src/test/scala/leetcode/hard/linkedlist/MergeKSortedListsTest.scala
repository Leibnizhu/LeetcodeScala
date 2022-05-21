package leetcode.hard.linkedlist

import leetcode.common.ListNode
import org.scalatest.funsuite.AnyFunSuite

class MergeKSortedListsTest extends AnyFunSuite {
  test("sample1, k=3") {
    val l1 = ListNode.fromArray(Array(1, 4, 5))
    val l2 = ListNode.fromArray(Array(1, 3, 4))
    val l3 = ListNode.fromArray(Array(2, 6))
    val result = MergeKSortedLists.mergeKLists(Array(l1, l2, l3))
    assert(ListNode.toArray(result, 8) sameElements Array(1, 1, 2, 3, 4, 4, 5, 6))
  }

  test("empty"){
    assert(ListNode.toArray(MergeKSortedLists.mergeKLists(Array[ListNode]()),0) sameElements Array[ListNode]())
  }
}
