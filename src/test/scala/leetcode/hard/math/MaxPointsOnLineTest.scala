package leetcode.hard.math

import org.scalatest.FunSuite

class MaxPointsOnLineTest extends FunSuite {
  test("empty") {
    assert(MaxPointsOnLine.maxPoints(Array()) == 0)
  }

  test("one point") {
    assert(MaxPointsOnLine.maxPoints(Array(Point(2, 2))) == 1)
  }

  test("three same point") {
    assert(MaxPointsOnLine.maxPoints(Array(Point(2, 2), Point(2, 2), Point(2, 2))) == 3)
  }

  test("two same point group") {
    assert(MaxPointsOnLine.maxPoints(Array(Point(2, 2), Point(2, 2), Point(1, 1), Point(1, 1))) == 4)
  }

  /**
    * ^
    * |
    * |        o
    * |     o
    * |  o
    * +------------->
    * 0  1  2  3  4
    **/
  test("sample1") {
    assert(MaxPointsOnLine.maxPoints(Array(Point(1, 1), Point(2, 2), Point(3, 3))) == 3)
  }

  /**
    * ^
    * |
    * |  o
    * |     o        o
    * |        o
    * |  o        o
    * +------------------->
    * 0  1  2  3  4  5  6
    **/
  test("sample2") {
    assert(MaxPointsOnLine.maxPoints(Array(Point(1, 1), Point(3, 2), Point(5, 3), Point(4, 1), Point(2, 3), Point(1, 4))) == 4)
  }

  test("sample3") {
    assert(MaxPointsOnLine.maxPoints(Array(Point(0, 0), Point(94911151, 94911150), Point(94911152, 94911151))) == 2)
  }

  test("sample4") {
    assert(MaxPointsOnLine.maxPoints(Array(Point(0, 0), Point(1, 1), Point(1, -1))) == 2)
  }
}
