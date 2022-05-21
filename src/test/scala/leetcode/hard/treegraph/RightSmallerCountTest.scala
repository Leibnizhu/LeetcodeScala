package leetcode.hard.treegraph

import org.scalatest.funsuite.AnyFunSuite

class RightSmallerCountTest extends AnyFunSuite {
  test("empty") {
    assert(RightSmallerCount.countSmaller(Array[Int]()).isEmpty)
  }

  test("one element") {
    assert(RightSmallerCount.countSmaller(Array(2)) == List(0))
  }

  test("[1,2]") {
    assert(RightSmallerCount.countSmaller(Array(1, 2)) == List(0, 0))
  }

  test("[2,1]") {
    assert(RightSmallerCount.countSmaller(Array(2, 1)) == List(1, 0))
  }

  test("[5,2,6,1]") {
    assert(RightSmallerCount.countSmaller(Array(5, 2, 6, 1)) == List(2, 1, 1, 0))
  }

  test("[5,2,2,6,1]") {
    assert(RightSmallerCount.countSmaller(Array(5, 2, 2, 6, 1)) == List(3, 1, 1, 1, 0))
  }
}
