package leetcode.hard.treegraph

import leetcode.common.TreeNode
import org.scalatest.funsuite.AnyFunSuite

class MaxPathSumTest extends AnyFunSuite {
  test("1,2,3") {
    val root = TreeNode(Array[Integer](1, 2, 3))
    assert(MaxPathSum.maxPathSum(root) == 6)
  }

  test("-10,9,20,null,null,15,7") {
    val root = TreeNode(Array[Integer](-10, 9, 20, null, null, 15, 7))
    assert(MaxPathSum.maxPathSum(root) == 42)
  }
}
