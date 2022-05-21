package leetcode.hard.linkedlist

import org.scalatest.funsuite.AnyFunSuite

class CopyRandomLinkedListTest extends AnyFunSuite {
  test("1->2->3"){
    val p1 = new CopyRandomLinkedList.RandomListNode(1)
    val p2 = new CopyRandomLinkedList.RandomListNode(2)
    val p3 = new CopyRandomLinkedList.RandomListNode(3)
    p1.next = p2
    p2.next = p3
    p1.random = p3
    p2.random = null
    p3.random = p2
    val copy = new CopyRandomLinkedList()
    val result = copy.copyRandomList(p1)
    val newP1 = result
    val newP2 = newP1.next
    val newP3 = newP2.next
    assert(newP1.label == 1)
    assert(newP2.label == 2)
    assert(newP3.label == 3)
    assert(newP1.random == newP3)
    assert(newP2.random == null)
    assert(newP3.random == newP2)
    assert(p1.next == p2)
    assert(p2.next == p3)
  }
}
