package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class CutOffTreesForGolfEventTest extends AnyFunSuite {
  test("case1") {
    assertResult(6)(CutOffTreesForGolfEvent.cutOffTree(List(List(1, 2, 3), List(0, 0, 4), List(7, 6, 5))))
  }

  test("case2") {
    assertResult(-1)(CutOffTreesForGolfEvent.cutOffTree(List(List(1, 2, 3), List(0, 0, 0), List(7, 6, 5))))
  }

  test("case3") {
    assertResult(6)(CutOffTreesForGolfEvent.cutOffTree(List(List(2, 3, 4), List(0, 0, 5), List(8, 7, 6))))
  }
}
