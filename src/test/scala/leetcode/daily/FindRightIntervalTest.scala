package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class FindRightIntervalTest extends AnyFunSuite {
  test("case1") {
    assertResult(Array(-1))(FindRightInterval.findRightInterval(Array(Array(1, 2))))
  }

  test("case2") {
    assertResult(Array(-1, 0, 1))(FindRightInterval.findRightInterval(Array(Array(3, 4), Array(2, 3), Array(1, 2))))
  }

  test("case3") {
    assertResult(Array(-1, 2, -1))(FindRightInterval.findRightInterval(Array(Array(1, 4), Array(2, 3), Array(3, 4))))
  }
}
