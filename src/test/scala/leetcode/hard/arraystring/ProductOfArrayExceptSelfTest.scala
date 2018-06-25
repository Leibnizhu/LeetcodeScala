package leetcode.hard.arraystring

import org.scalatest.FunSuite

class ProductOfArrayExceptSelfTest extends FunSuite {
  test("3,4") {
    assert(ProductOfArrayExceptSelf.productExceptSelf(Array(3, 4)) sameElements Array(4, 3))
  }

  test("1,2,3") {
    assert(ProductOfArrayExceptSelf.productExceptSelf(Array(1, 2, 3)) sameElements Array(6, 3, 2))
  }

  test("1,2,3,4") {
    assert(ProductOfArrayExceptSelf.productExceptSelf(Array(1, 2, 3, 4)) sameElements Array(24, 12, 8, 6))
  }
}
