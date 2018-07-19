package leetcode.hard.dynamic

import org.scalatest.FunSuite

class PerfectSquaresTest extends FunSuite {
  test("1 = 1") {
    assert(PerfectSquares.numSquares(1) == 1)
  }

  test("2 = 1 + 1") {
    assert(PerfectSquares.numSquares(2) == 2)
  }

  test("12 = 4 + 4 + 4") {
    assert(PerfectSquares.numSquares(12) == 3)
  }

  test("13 = 4 + 9") {
    assert(PerfectSquares.numSquares(13) == 2)
  }
}
