package leetcode.medium.treegraph

import leetcode.medium.treegraph.ConnectTreeNode.TreeLinkNode
import org.scalatest.funsuite.AnyFunSuite

class ConnectTreeNodeTest extends AnyFunSuite{
    test("3 level perfect binary tree"){
      val node4 = new TreeLinkNode(4)
      val node5 = new TreeLinkNode(5)
      val node6 = new TreeLinkNode(6)
      val node7 = new TreeLinkNode(7)
      val node2 = new TreeLinkNode(2,node4,node5)
      val node3 = new TreeLinkNode(3,node6,node7)
      val node1 = new TreeLinkNode(1,node2,node3)
      new ConnectTreeNode().connect(node1)
      assert(node1.next == null)
      assert(node2.next == node3)
      assert(node3.next == null)
      assert(node4.next == node5)
      assert(node5.next == node6)
      assert(node6.next == node7)
      assert(node7.next == null)
    }
}
