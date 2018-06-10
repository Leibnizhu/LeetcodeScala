package leetcode.medium.arraystring

import org.scalatest.FunSuite

class ThreeSumTest extends FunSuite {
  test("-1 0 1 2 -1 -4") {
    val result = ThreeSum.threeSum(Array(-1, 0, 1, 2, -1, -4))
    assert(result.length == 2)
    result.foreach(arr => assert(arr.sum ==0))
  }

  test("0,0,0") {
    val result = ThreeSum.threeSum(Array(0, 0, 0))
    assert(result.length == 1)
    result.foreach(arr => assert(arr.sum ==0))
  }

  test("0,0,1") {
    val result = ThreeSum.threeSum(Array(0, 0, 1))
    assert(result.isEmpty)
  }

  test("maxInt,minInt,1") {
    val result = ThreeSum.threeSum(Array(Int.MaxValue, Int.MinValue, 1))
    assert(result.length == 1)
    result.foreach(arr => assert(arr.sum ==0))
  }
}
