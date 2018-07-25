package leetcode.hard.other

import org.scalatest.FunSuite

class LargestRectangleInHistogramTest extends FunSuite {
  test("sample1") {
    assert(LargestRectangleInHistogram.largestRectangleArea(Array(2, 1, 5, 6, 2, 3)) == 10)
  }

  test("sample2") {
    assert(LargestRectangleInHistogram.largestRectangleArea(Array(6, 2, 5, 4, 5, 1, 6)) == 12)
  }

  test("sample3") {
    assert(LargestRectangleInHistogram.largestRectangleArea(Array(1)) == 1)
  }

  test("sample4") {
    assert(LargestRectangleInHistogram.largestRectangleArea(Array(1, 2, 3, 4, 5)) == 9)
  }
}