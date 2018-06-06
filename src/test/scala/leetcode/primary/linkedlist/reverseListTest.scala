package leetcode.primary.linkedlist

import org.scalatest.FunSuite

class reverseListTest extends FunSuite {

  test("1->2->3->4->5") {
    check(Array(1, 2, 3, 4, 5), Array(5, 4, 3, 2, 1))
  }

  test("1") {
    check(Array(1), Array(1))
  }

  private def check(oldNodes: Array[Int], shouldBe: Array[Int]): Unit = {
    val len = oldNodes.length
    val oldList = ListNode.makeLinkedList(oldNodes, len)
    val newList = ReverseList.reverseList(oldList)
    val newNodes = ListNode.linkedListToArray(newList, len)
    assert(newNodes sameElements shouldBe)
  }
}
