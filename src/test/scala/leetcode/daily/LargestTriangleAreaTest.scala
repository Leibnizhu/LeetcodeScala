package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class LargestTriangleAreaTest extends AnyFunSuite {
  test("case1"){
    assertResult(2)(LargestTriangleArea.largestTriangleArea(Array(Array(0,0),Array(0,1),Array(1,0),Array(0,2),Array(2,0))))
  }
}
