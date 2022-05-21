package leetcode.medium.math

import org.scalatest.funsuite.AnyFunSuite

class SquareRootTest extends AnyFunSuite {
  test("4") {
    assert(SquareRoot.mySqrt(4) == 2)
  }

  test("8") {
    assert(SquareRoot.mySqrt(8) == 2)
  }

  test("26") {
    assert(SquareRoot.mySqrt(26) == 5)
  }

  test("2147395599"){
    assert(SquareRoot.mySqrt(2147395599) == 46339)
  }
}
