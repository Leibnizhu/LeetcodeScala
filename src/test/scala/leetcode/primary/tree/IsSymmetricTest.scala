package leetcode.primary.tree

import leetcode.common.TreeNode
import org.scalatest.funsuite.AnyFunSuite

class IsSymmetricTest extends AnyFunSuite{
  /**
    *     1
    *    / \
    *   2   2
    *  / \ / \
    * 3  4 4  3
    */
  test("1,2,2,3,4,4,3"){
    check(Array[Integer](1,2,2,3,4,4,3), shouldBe = true)
  }

  /**
    *    1
    *   / \
    *  2   2
    *   \   \
    *   3    3
    */
  test("1,2,2,null,3,null,3"){
    check(Array[Integer](1,2,2,null,3,null,3), shouldBe = false)
  }

  /**
    *     1
    *   /  \
    *  2    2
    *   \  /
    *   3 3
    */
  test("1,2,2,null,3,3"){
    check(Array[Integer](1,2,2,null,3,3), shouldBe = true)
  }

  test("2,2,2"){
    check(Array[Integer](2,2,2), shouldBe = true)
  }

  test("1,2,3"){
    check(Array[Integer](1,2,3), shouldBe = false)
  }

  test("2147483647"){
    check(Array[Integer](2147483647), shouldBe = true)
  }

  test("-2147483648"){
    check(Array[Integer](-2147483648), shouldBe = true)
  }

  test("null"){
    check(null, shouldBe = true)
  }

  test("empty"){
    check(Array[Integer](), shouldBe = true)
  }

  def check(arr: Array[Integer], shouldBe: Boolean): Unit = {
    val tree = TreeNode(arr)
    val result = IsSymmetric.isSymmetric(tree)
    assert(result == shouldBe)
  }
}
