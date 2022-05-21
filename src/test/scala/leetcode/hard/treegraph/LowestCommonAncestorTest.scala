package leetcode.hard.treegraph

import leetcode.medium.design.BinaryTreeCodec.TreeNode
import org.scalatest.funsuite.AnyFunSuite

class LowestCommonAncestorTest extends AnyFunSuite {
  test("sample1") {
    val n0 = new TreeNode(0)
    val n1 = new TreeNode(1)
    val n2 = new TreeNode(2)
    val n3 = new TreeNode(3)
    val n4 = new TreeNode(4)
    val n5 = new TreeNode(5)
    val n6 = new TreeNode(6)
    val n7 = new TreeNode(7)
    val n8 = new TreeNode(8)
    n3.left = n5
    n3.right = n1
    n5.left = n6
    n5.right = n2
    n2.left = n7
    n2.right = n4
    n1.left = n0
    n1.right = n8
    val lac = new LowestCommonAncestor()

    def check(x: TreeNode, y: TreeNode)(shouldBe: TreeNode): Unit = {
      assert(lac.lowestCommonAncestor(n3, x, y) == shouldBe)
    }

    check(n3, n1)(n3)
    check(n3, n5)(n3)
    check(n5, n2)(n5)
    check(n5, n6)(n5)
    check(n5, n1)(n3)
    check(n5, n0)(n3)
    check(n5, n8)(n3)
    check(n5, n4)(n5)
    check(n5, n7)(n5)
    check(n4, n7)(n2)
    check(n4, n6)(n5)
    check(n4, n3)(n3)
    check(n4, n1)(n3)
    check(n4, n0)(n3)
    check(n4, n8)(n3)
  }
}
