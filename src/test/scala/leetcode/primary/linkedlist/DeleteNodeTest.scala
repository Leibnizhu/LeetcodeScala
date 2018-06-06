package leetcode.primary.linkedlist

import org.scalatest.FunSuite

class DeleteNodeTest extends FunSuite {

  test("1 -> 2 -> 3 -> 4 , delete 3") {
    val node4 = new DeleteNode.ListNode(4, null)
    val node3 = new DeleteNode.ListNode(3, node4)
    val node2 = new DeleteNode.ListNode(2, node3)
    val node1 = new DeleteNode.ListNode(1, node2)
    val linkedList = new DeleteNode()
    linkedList.deleteNode(node3)
    assert(node2.next.equals(node4))
  }

}
