package leetcode.medium.treegraph

import org.scalatest.funsuite.AnyFunSuite

class BuildTreeTest extends AnyFunSuite {
  test(" [3,9,20,15,7] && [9,3,15,20,7]") {
    val root = BuildTree.buildTree(Array(3, 9, 20, 15, 7), Array(9, 3, 15, 20, 7))
    assert(root.value == 3)
    assert(root.left.value == 9)
    assert(root.left.value == 9)
    assert(root.right.left.value == 15)
    assert(root.right.right.value == 7)
  }

  test("[1] && [1]") {
    val root = BuildTree.buildTree(Array(1), Array(1))
    assert(root.value == 1)
    assert(root.left == null)
    assert(root.right == null)
  }

  test("null && null") {
    val root = BuildTree.buildTree(Array(), Array())
    assert(root == null)
  }
}
