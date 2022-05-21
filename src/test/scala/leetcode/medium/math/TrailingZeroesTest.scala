package leetcode.medium.math

import org.scalatest.funsuite.AnyFunSuite

class TrailingZeroesTest extends AnyFunSuite{
  test("3"){
    assert(TrailingZeroes.trailingZeroes(3) == 0)
  }

  test("5"){
    assert(TrailingZeroes.trailingZeroes(5) == 1)
  }

  test("25"){
    assert(TrailingZeroes.trailingZeroes(25) == 6)
  }

  test("27"){
    assert(TrailingZeroes.trailingZeroes(27) == 6)
  }
}
