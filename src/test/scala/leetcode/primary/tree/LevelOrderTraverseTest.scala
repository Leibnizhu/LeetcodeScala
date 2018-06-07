package leetcode.primary.tree

import org.scalatest.FunSuite

class LevelOrderTraverseTest extends FunSuite{
  /**
  *     1
  *    / \
  *   2   2
  *  / \ / \
  * 3  4 4  3
  */
  test("1,2,2,3,4,4,3"){
    check(Array[Integer](1,2,2,3,4,4,3), shouldBe = List(List(1),List(2,2),List(3,4,4,3)))
  }

  /**
    *    1
    *   / \
    *  2   2
    *   \   \
    *   3    3
    */
  test("1,2,2,null,3,null,3"){
    check(Array[Integer](1,2,2,null,3,null,3), shouldBe = List(List(1),List(2,2),List(3,3)))
  }

  /**
    *     1
    *   /  \
    *  2    2
    *   \  /
    *   3 3
    */
  test("1,2,2,null,3,3"){
    check(Array[Integer](1,2,2,null,3,3), shouldBe = List(List(1),List(2,2),List(3,3)))
  }

  test("2,2,2"){
    check(Array[Integer](2,2,2), shouldBe = List(List(2),List(2,2)))
  }

  test("1,2,3"){
    check(Array[Integer](1,2,3), shouldBe = List(List(1),List(2,3)))
  }

  test("2147483647"){
    check(Array[Integer](2147483647), shouldBe = List(List(2147483647)))
  }

  test("-2147483648"){
    check(Array[Integer](-2147483648), shouldBe = List(List(-2147483648)))
  }

  def check(arr: Array[Integer], shouldBe: List[List[Int]]): Unit = {
    val tree = TreeNode(arr)
    val result = LevelOrderTraverse.levelOrder(tree)
    assert(result.size == shouldBe.size)
    for(i <- result.indices){
      assert(result(i) == shouldBe(i))
    }
  }
}
