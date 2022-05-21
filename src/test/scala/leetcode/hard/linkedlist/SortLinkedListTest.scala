package leetcode.hard.linkedlist

import leetcode.common.ListNode
import org.scalatest.funsuite.AnyFunSuite

class SortLinkedListTest extends AnyFunSuite {

  def check(arr: Array[Int], shouldBe: Array[Int]): Unit = {
    val head = ListNode.fromArray(arr)
    val sortedHead = SortLinkedList.sortList(head)
    assert(ListNode.toArray(sortedHead, arr.length) sameElements shouldBe)
  }

  test("empty") {
    check(Array[Int](), Array[Int]())
  }

  test("4") {
    check(Array(4), Array(4))
  }

  test("4->2->1->3") {
    check(Array(4, 2, 1, 3), Array(1, 2, 3, 4))
  }


  test("-1->5->3->4->0") {
    check(Array(-1, 5, 3, 4, 0), Array(-1, 0, 3, 4, 5))
  }
}
