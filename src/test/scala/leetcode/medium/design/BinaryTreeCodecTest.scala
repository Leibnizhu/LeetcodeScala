package leetcode.medium.design

import org.scalatest.FunSuite

class BinaryTreeCodecTest extends FunSuite {
  test("serialize-sample1") {
    val l = new BinaryTreeCodec.TreeNode(2)
    val r = new BinaryTreeCodec.TreeNode(3)
    val root = new BinaryTreeCodec.TreeNode(1)
    root.left = l
    root.right = r
    val codec = new BinaryTreeCodec()
    println(codec.serialize(root))
    assert(codec.serialize(root).equals("1,2,#,#,3,#,#,"))
  }

  test("serialize-sample2") {
    val r = new BinaryTreeCodec.TreeNode(3)
    val root = new BinaryTreeCodec.TreeNode(1)
    root.right = r
    val codec = new BinaryTreeCodec()
    println(codec.serialize(root))
    assert(codec.serialize(root).equals("1,#,3,#,#,"))
  }

  test("serialize-sample3") {
    val rr = new BinaryTreeCodec.TreeNode(3)
    val r = new BinaryTreeCodec.TreeNode(2)
    val root = new BinaryTreeCodec.TreeNode(1)
    root.right = r
    r.right = rr
    val codec = new BinaryTreeCodec()
    println(codec.serialize(root))
    assert(codec.serialize(root).equals("1,#,2,#,3,#,#,"))
  }

  test("deserialize-sample1") {
    val codec = new BinaryTreeCodec()
    val root = codec.deserialize("1,2,#,#,3,#,#,")
    assert(root.`val` == 1)
    val l = root.left
    assert(l.`val` == 2)
    assert(l.left == null)
    assert(l.right == null)
    val r = root.right
    assert(r.`val` == 3)
    assert(r.left == null)
    assert(r.right == null)
  }

  test("deserialize-sample2") {
    val codec = new BinaryTreeCodec()
    val root = codec.deserialize("1,#,3,#,#,")
    assert(root.`val` == 1)
    assert(root.left == null)
    val r = root.right
    assert(r.`val` == 3)
    assert(r.left == null)
    assert(r.right == null)
  }

  test("deserialize-sample3") {
    val codec = new BinaryTreeCodec()
    val root = codec.deserialize("1,#,2,#,3,#,#,")
    assert(root.`val` == 1)
    assert(root.left == null)
    val r = root.right
    assert(r.`val` == 2)
    assert(r.left == null)
    val rr = r.right
    assert(rr.`val` == 3)
    assert(rr.left == null)
    assert(rr.right == null)
  }

  test("serialize-deserialize") {
    val n4 = new BinaryTreeCodec.TreeNode(4)
    val n5 = new BinaryTreeCodec.TreeNode(5)
    val n3 = new BinaryTreeCodec.TreeNode(3)
    n3.left = n4
    n3.right = n5
    val n2 = new BinaryTreeCodec.TreeNode(2)
    val n1 = new BinaryTreeCodec.TreeNode(1)
    n1.left = n2
    n1.right = n3
    val codec = new BinaryTreeCodec()
    val root = codec.deserialize(codec.serialize(n1))
    assert(root.`val` == 1)
  }
}
