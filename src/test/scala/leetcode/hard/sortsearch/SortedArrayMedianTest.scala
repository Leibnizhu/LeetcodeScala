package leetcode.hard.sortsearch

import org.scalatest.FunSuite

class SortedArrayMedianTest extends FunSuite {
  test("sample1") {
    assert(SortedArrayMedian.findMedianSortedArrays(Array(1, 3), Array(2)) == 2)
  }

  test("sample2") {
    assert(SortedArrayMedian.findMedianSortedArrays(Array(1, 2), Array(3, 4)) == 2.5)
  }

  test("sample3") {
    assert(SortedArrayMedian.findMedianSortedArrays(Array(1), Array(3, 4, 7, 8, 11)) == 5.5)
  }

  test("sample4") {
    assert(SortedArrayMedian.findMedianSortedArrays(Array(3, 4, 7, 8, 11), Array(1)) == 5.5)
  }
}
