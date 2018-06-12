package leetcode.medium.treegraph

import leetcode.common.TreeNode
import org.scalatest.FunSuite

class ZigZagLevelOrderTraversalTest extends FunSuite {
  test("3,9,20,null,null,15,7") {
    val root = TreeNode(Array[Integer](3, 9, 20, null, null, 15, 7))
    val result = ZigZagLevelOrderTraversal.zigzagLevelOrder(root)
    assert(result.size == 3)
    assert(result.head == List(3))
    assert(result(1) == List(20, 9))
    assert(result(2) == List(15, 7))
  }
}
