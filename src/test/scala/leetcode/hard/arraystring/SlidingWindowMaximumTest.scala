package leetcode.hard.arraystring

import org.scalatest.funsuite.AnyFunSuite

class SlidingWindowMaximumTest extends AnyFunSuite {
  test("null, k = 3") {
    assert(SlidingWindowMaximum.maxSlidingWindow(null, 3) sameElements Array[Int]())
  }

  test("empty, k = 3") {
    assert(SlidingWindowMaximum.maxSlidingWindow(Array(), 3) sameElements Array[Int]())
  }

  test("[1,3,-1,-3,5,3,6,7],k = 3") {
    assert(SlidingWindowMaximum.maxSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 3) sameElements Array(3, 3, 5, 5, 6, 7))
  }
}
