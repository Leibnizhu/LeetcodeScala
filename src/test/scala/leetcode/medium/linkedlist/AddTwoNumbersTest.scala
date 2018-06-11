package leetcode.medium.linkedlist

import leetcode.common.ListNode
import org.scalatest.FunSuite

class AddTwoNumbersTest extends FunSuite {
  test("(2 -> 4 -> 3) + (5 -> 6 -> 4)") {
    val list1 = ListNode.makeLinkedList(Array(2, 4, 3), 3)
    val list2 = ListNode.makeLinkedList(Array(5, 6, 4), 3)
    val result = AddTwoNumbers.addTwoNumbers(list1, list2)
    assert(ListNode.linkedListToArray(result, 3) sameElements Array(7, 0, 8))
  }
}
