package leetcode.hard.design

import org.scalatest.funsuite.AnyFunSuite

class MedianFinderTest extends AnyFunSuite {
  test("sample1") {
    val finder = new MedianFinder
    finder.addNum(1)
    finder.addNum(2)
    assert(finder.findMedian() == 1.5)
    finder.addNum(3)
    assert(finder.findMedian() == 2)
  }

  test("sample2") {
    val finder = new MedianFinder
    finder.addNum(-1)
    assert(finder.findMedian() == -1.0)
    finder.addNum(-2)
    assert(finder.findMedian() == -1.5)
    finder.addNum(-3)
    assert(finder.findMedian() == -2.0)
    finder.addNum(-4)
    assert(finder.findMedian() == -2.5)
    finder.addNum(-5)
    assert(finder.findMedian() == -3.0)
  }
}
