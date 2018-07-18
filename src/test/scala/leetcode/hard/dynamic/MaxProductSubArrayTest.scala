package leetcode.hard.dynamic

import org.scalatest.FunSuite

class MaxProductSubArrayTest extends FunSuite {
  test("2,3,-2,4") {
    assert(MaxProductSubArray.maxProduct(Array(2, 3, -2, 4)) == 6)
  }

  test("-3,-2,-1,1") {
    assert(MaxProductSubArray.maxProduct(Array(-3, -2, -1, 1)) == 6)
  }

  test("-2,0,-1") {
    assert(MaxProductSubArray.maxProduct(Array(-2, 0, -1)) == 0)
  }
}
