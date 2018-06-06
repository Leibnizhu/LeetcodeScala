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
    val oldList = makeLinkedList(oldNodes, len)
    val newList = ReverseList.reverseList(oldList(0))
    val newNodes = linkedListToArray(newList, len)
    assert(newNodes sameElements shouldBe)
  }

  private def makeLinkedList(nodes: Array[Int], len: Int): Array[ListNode] = {
    val nodeList = new Array[ListNode](len)
    nodeList(len - 1) = ListNode(nodes.last, null)
    for (i <- len - 2 to 0 by -1) {
      nodeList(i) = ListNode(nodes(i), nodeList(i + 1))
    }
    nodeList
  }

  private def linkedListToArray(newList: ListNode, len: Int): Array[Int] = {
    var cur = newList
    val result = new Array[Int](len)
    var i = 0
    while(cur != null){
      result(i) = cur.x
      i+=1
      cur = cur.next
    }
    result
  }
}
