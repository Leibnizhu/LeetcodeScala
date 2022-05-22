package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class CanIWinTest extends AnyFunSuite {
  test("case1") {
    assertResult(false)(CanIWin.canIWin(10, 11))
  }

  test("case2") {
    assertResult(true)(CanIWin.canIWin(10, 0))
  }

  test("case3") {
    assertResult(true)(CanIWin.canIWin(10, 1))
  }

  test("case4") {
    assertResult(false)(CanIWin.canIWin(10, 40))
  }

  test("case5") {
    assertResult(true)(CanIWin.canIWin(4, 6))
  }
}
