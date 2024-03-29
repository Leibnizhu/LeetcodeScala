package leetcode.primary.linkedlist

import leetcode.common.ListNode
import org.scalatest.funsuite.AnyFunSuite

class RemoveNthFromEndTest extends AnyFunSuite {

  test("1->2->3->4->5, n = 2") {
    check(Array(1, 2, 3, 4, 5), 2)
  }

  test("1->2->3->4->5, n = 1") {
    check(Array(1, 2, 3, 4, 5), 1)
  }

  test("1, n = 1") {
    check(Array(1), 1)
  }

  test("1->2->3, n = 3") {
    check(Array(1,2,3), 3)
  }

  def check(nodes: Array[Int], n: Int):Unit = {
    val len = nodes.length
    val nodeList = makeLinkedList(nodes, len)
    val head = RemoveNthFromEnd.removeNthFromEnd(nodeList(0), n)

    if (n == nodes.length) {
      //删除队头
      assert(head == nodeList(0).next || head.equals(nodeList(0).next))
    } else if (n == 1) {
      //删除队尾,删除点的下一个为null
      assert(nodeList(len - 1 - n).next == null)
      assert(head.equals(nodeList(0)))
    } else {
      //删除队中,删除点前后next相连
      assert(nodeList(len - 1 - n).next.equals(nodeList(len + 1 - n)))
      assert(head.equals(nodeList(0)))
    }
  }

  private def makeLinkedList(nodes: Array[Int], len:Int): Array[ListNode] = {
    val nodeList = new Array[ListNode](len)
    nodeList(len - 1) = ListNode(nodes.last)
    for (i <- len - 2 to 0 by -1) {
      nodeList(i) = ListNode(nodes(i), nodeList(i + 1))
    }
    nodeList
  }
}
