package leetcode.medium.treegraph

import leetcode.common.TreeNode
import org.scalatest.FunSuite

class InOrderTraversalTest extends FunSuite{
  test("1,null,2,3"){
    val root = TreeNode(Array[Integer](1,null,2,null,null,3))
    val result = InOrderTraversal.inOrderTraversal(root)
    assert(result == List(1, 3, 2))
  }

  test("null"){
    val root = null
    val result = InOrderTraversal.inOrderTraversal(root)
    assert(result == List())
  }

  test("1"){
    val root = TreeNode(Array[Integer](1))
    val result = InOrderTraversal.inOrderTraversal(root)
    assert(result == List(1))
  }
}
