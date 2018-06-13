package leetcode.medium.treegraph

import leetcode.common.TreeNode
import org.scalatest.FunSuite

class KthSmallestTest extends FunSuite {
  test("[3,1,4,null,2], 1") {
    assert(KthSmallest.kthSmallest(TreeNode(Array[Integer](3, 1, 4, null, 2)), 1) == 1)
  }

  test("[5,3,6,2,4,null,null,1], 3") {
    assert(KthSmallest.kthSmallest(TreeNode(Array[Integer](5, 3, 6, 2, 4, null, null, 1)), 3) == 3)
  }
}
