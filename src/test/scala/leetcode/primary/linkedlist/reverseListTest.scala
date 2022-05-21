package leetcode.primary.linkedlist

import leetcode.common.ListNode
import org.scalatest.funsuite.AnyFunSuite

class reverseListTest extends AnyFunSuite {

  test("1->2->3->4->5") {
    check(Array(1, 2, 3, 4, 5), Array(5, 4, 3, 2, 1))
  }

  test("1") {
    check(Array(1), Array(1))
  }

  private def check(oldNodes: Array[Int], shouldBe: Array[Int]): Unit = {
    val oldList = ListNode.fromArray(oldNodes)
    val newList = ReverseList.reverseList(oldList)
    val newNodes = ListNode.toArray(newList, oldNodes.length)
    assert(newNodes sameElements shouldBe)
  }
}
