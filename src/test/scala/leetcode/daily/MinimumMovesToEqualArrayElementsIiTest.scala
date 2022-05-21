package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class MinimumMovesToEqualArrayElementsIiTest extends AnyFunSuite {
  test("case1") {
    assertResult(2)(MinimumMovesToEqualArrayElementsIi.minMoves2(Array(1, 2, 3)))
  }

  test("case2") {
    assertResult(16)(MinimumMovesToEqualArrayElementsIi.minMoves2(Array(1, 10, 2, 9)))
  }
}
