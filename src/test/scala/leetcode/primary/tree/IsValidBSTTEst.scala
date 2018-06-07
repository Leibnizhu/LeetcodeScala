package leetcode.primary.tree

import org.scalatest.FunSuite


class IsValidBSTTEst extends FunSuite{

  /**
    *   2
    *  / \
    * 1   3
    */
  test("2,1,3"){
    check(Array[Integer](2,1,3), shouldBe = true)
  }

  /**
    *   5
    *  / \
    * 1   4
    *    / \
    *   3   6
    * 解释: 输入为: [5,1,4,null,null,3,6]。
    * 根节点的值为 5 ，但是其右子节点值为 4 。
    */
  test("5,1,4,null,null,3,6"){
    check(Array[Integer](5,1,4,null,null,3,6), shouldBe = false)
  }

  test("2"){
    check(Array[Integer](2), shouldBe = true)
  }

  test("2,2,2"){
    check(Array[Integer](2,2,2), shouldBe = false)
  }

  test("2147483647"){
    check(Array[Integer](2147483647), shouldBe = true)
  }

  test("-2147483648"){
    check(Array[Integer](-2147483648), shouldBe = true)
  }

  def check(arr: Array[Integer], shouldBe: Boolean): Unit = {
    val tree = TreeNode(arr)
    val result = IsValidBST.isValidBST(tree)
    assert(result == shouldBe)
  }

}
