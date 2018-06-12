package leetcode.medium.linkedlist

import leetcode.common.ListNode
import org.scalatest.FunSuite

class AddTwoNumbersTest extends FunSuite {
  test("(2 -> 4 -> 3) + (5 -> 6 -> 4)") {
    check(Array(2, 4, 3), Array(5, 6, 4), 3, Array(7, 0, 8))
  }

  test("(1 -> 2) + (9 -> 7)") {
    check(Array(1, 2), Array(9, 7), 3, Array(0, 0, 1))
  }

  test("(1) + (9 -> 9)") {
    check(Array(1), Array(9, 9), 3, Array(0, 0, 1))
  }

  test("(9 -> 9) + (1)") {
    check(Array(9, 9), Array(1), 3, Array(0, 0, 1))
  }

  test("(0 ) + (0)") {
    check(Array(0), Array(0), 1, Array(0))
  }

  def check(arr1: Array[Int], arr2: Array[Int], shouldBeLen: Int, shouldBe: Array[Int]) = {
    val list1 = ListNode.fromArray(arr1)
    val list2 = ListNode.fromArray(arr2)
    val result = AddTwoNumbers.addTwoNumbers(list1, list2)
    println(ListNode.toArray(result, shouldBeLen).toList)
    assert(ListNode.toArray(result, shouldBeLen) sameElements shouldBe)
  }
}
