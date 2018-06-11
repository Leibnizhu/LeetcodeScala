package leetcode.primary.tree

import leetcode.common.TreeNode
import org.scalatest.FunSuite

class MaxDepthTest extends FunSuite {

  test("3,9,20,null,null,15,7") {
    check(Array[Integer](3,9,20,null,null,15,7), 3)
  }

  test("3") {
    check(Array[Integer](3), 1)
  }

  test("3,null,null") {
    check(Array[Integer](3,null,null), 1)
  }

  def check(array: Array[Integer], shouldBe: Int): Unit = {
    val treeRoot = TreeNode(array)
    val depth = MaxDepth.maxDepth(treeRoot)
    assert(depth == shouldBe)
  }
}
