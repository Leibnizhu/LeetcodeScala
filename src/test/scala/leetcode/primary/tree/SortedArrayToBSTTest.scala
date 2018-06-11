package leetcode.primary.tree

import leetcode.common.TreeNode
import org.scalatest.FunSuite

class SortedArrayToBSTTest extends FunSuite{

  /**
    * 给定有序数组: [-10,-3,0,5,9],
    * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
    *       0
    *      / \
    *    -3   9
    *   /   /
    * -10  5
    */
  test("-10,-3,0,5,9"){
    check(Array(-10,-3,0,5,9))
  }
  
  test("1,2,3,4"){
    check(Array(1,2,3,4))
  }

  test("1,2,3"){
    check(Array(1,2,3))
  }

  test("2147483647"){
    check(Array(2147483647))
  }

  test("-2147483648"){
    check(Array(-2147483648))
  }

  def check(nodes: Array[Int]): Unit = {
    val root = SortedArrayToBST.sortedArrayToBST(nodes)
    println(root)
    //既满足二叉搜索树要求,又满足高度平衡树要求
    assert(IsValidBST.isValidBST(root) && TreeNode.isHighlyBalancedTree(root))
  }

}
