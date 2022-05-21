package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class SuccessorLcciTest extends AnyFunSuite {
  test("case1") {
    val root = new SuccessorLcci.TreeNode(2)
    val l = new SuccessorLcci.TreeNode(1)
    val r = new SuccessorLcci.TreeNode(3)
    root.left = l
    root.right = r
    assertResult(root)(new SuccessorLcci().inorderSuccessor(root, l))
  }

  test("case2") {
    val root = new SuccessorLcci.TreeNode(5)
    val n1 = new SuccessorLcci.TreeNode(1)
    val n2 = new SuccessorLcci.TreeNode(2)
    val n3 = new SuccessorLcci.TreeNode(3)
    val n4 = new SuccessorLcci.TreeNode(4)
    val n6 = new SuccessorLcci.TreeNode(6)
    root.left = n3
    root.right = n6
    n3.left = n2
    n3.right = n4
    n2.left = n1
    assertResult(null)(new SuccessorLcci().inorderSuccessor(root, n6))
  }

}
