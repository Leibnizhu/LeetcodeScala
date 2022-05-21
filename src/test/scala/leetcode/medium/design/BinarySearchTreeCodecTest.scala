package leetcode.medium.design

import org.scalatest.funsuite.AnyFunSuite

class BinarySearchTreeCodecTest extends AnyFunSuite {
  test("serialize-sample1") {
    val l = new BinarySearchTreeCodec.BSTNode(1)
    val r = new BinarySearchTreeCodec.BSTNode(3)
    val root = new BinarySearchTreeCodec.BSTNode(2)
    root.left = l
    root.right = r
    val codec = new BinarySearchTreeCodec()
    println(codec.serialize(root))
    assert(codec.serialize(root).equals("2,1,3,"))
  }

  test("serialize-sample2") {
    val r = new BinarySearchTreeCodec.BSTNode(3)
    val root = new BinarySearchTreeCodec.BSTNode(1)
    root.right = r
    val codec = new BinarySearchTreeCodec()
    println(codec.serialize(root))
    assert(codec.serialize(root).equals("1,3,"))
  }

  test("serialize-sample3") {
    val rr = new BinarySearchTreeCodec.BSTNode(3)
    val r = new BinarySearchTreeCodec.BSTNode(2)
    val root = new BinarySearchTreeCodec.BSTNode(1)
    root.right = r
    r.right = rr
    val codec = new BinarySearchTreeCodec()
    println(codec.serialize(root))
    assert(codec.serialize(root).equals("1,2,3,"))
  }

  test("deserialize-sample1") {
    val codec = new BinarySearchTreeCodec()
    val root = codec.deserialize("2,1,3,")
    assert(root.value == 2)
    val l = root.left
    assert(l.value == 1)
    assert(l.left == null)
    assert(l.right == null)
    val r = root.right
    assert(r.value == 3)
    assert(r.left == null)
    assert(r.right == null)
  }

  test("deserialize-sample2") {
    val codec = new BinarySearchTreeCodec()
    val root = codec.deserialize("1,3,")
    assert(root.value == 1)
    assert(root.left == null)
    val r = root.right
    assert(r.value == 3)
    assert(r.left == null)
    assert(r.right == null)
  }

  test("deserialize-sample3") {
    val codec = new BinarySearchTreeCodec()
    val root = codec.deserialize("1,2,3,")
    assert(root.value == 1)
    assert(root.left == null)
    val r = root.right
    assert(r.value == 2)
    assert(r.left == null)
    val rr = r.right
    assert(rr.value == 3)
    assert(rr.left == null)
    assert(rr.right == null)
  }

  test("serialize-deserialize") {
    val n4 = new BinarySearchTreeCodec.BSTNode(4)
    val n5 = new BinarySearchTreeCodec.BSTNode(5)
    val n3 = new BinarySearchTreeCodec.BSTNode(3)
    n3.left = n4
    n3.right = n5
    val n2 = new BinarySearchTreeCodec.BSTNode(2)
    val n1 = new BinarySearchTreeCodec.BSTNode(1)
    n1.left = n2
    n1.right = n3
    val codec = new BinarySearchTreeCodec()
    val root = codec.deserialize(codec.serialize(n1))
    assert(root.value == 1)
  }
}
