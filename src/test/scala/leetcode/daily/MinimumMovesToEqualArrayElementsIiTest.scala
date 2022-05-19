package leetcode.daily

import org.scalatest.FunSuite

class MinimumMovesToEqualArrayElementsIiTest extends FunSuite {
  test("case1") {
    assertResult(2)(MinimumMovesToEqualArrayElementsIi.minMoves2(Array(1, 2, 3)))
  }

  test("case2") {
    assertResult(16)(MinimumMovesToEqualArrayElementsIi.minMoves2(Array(1, 10, 2, 9)))
  }
}
