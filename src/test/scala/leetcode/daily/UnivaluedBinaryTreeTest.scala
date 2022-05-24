package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class UnivaluedBinaryTreeTest extends AnyFunSuite {
  test("case1") {
    val n1 = new TreeNode(1)
    val n2 = new TreeNode(1)
    val n3 = new TreeNode(1, n1, n2)
    val n4 = new TreeNode(1)
    val n5 = new TreeNode(1, null, n4)
    val root = new TreeNode(1, n3, n5)
    assertResult(true)(UnivaluedBinaryTree.isUnivalTree(root))
  }

  test("case2") {
    val n1 = new TreeNode(5)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(2, n1, n2)
    val n4 = new TreeNode(2)
    val root = new TreeNode(2, n3, n4)
    assertResult(false)(UnivaluedBinaryTree.isUnivalTree(root))
  }
}
