package leetcode.hard.math

import org.scalatest.funsuite.AnyFunSuite

class MaxPointsOnLineTest extends AnyFunSuite {
  test("empty") {
    assert(MaxPointsOnLine.maxPoints(Array()) == 0)
  }

  test("one point") {
    assert(MaxPointsOnLine.maxPoints(Array(new Point(2, 2))) == 1)
  }

  test("three same point") {
    assert(MaxPointsOnLine.maxPoints(Array(new Point(2, 2), new Point(2, 2), new Point(2, 2))) == 3)
  }

  test("two same point group") {
    assert(MaxPointsOnLine.maxPoints(Array(new Point(2, 2), new Point(2, 2), new Point(1, 1), new Point(1, 1))) == 4)
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
    assert(MaxPointsOnLine.maxPoints(Array(new Point(1, 1), new Point(2, 2), new Point(3, 3))) == 3)
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
    assert(MaxPointsOnLine.maxPoints(Array(new Point(1, 1), new Point(3, 2), new Point(5, 3), new Point(4, 1), new Point(2, 3), new Point(1, 4))) == 4)
  }

  test("sample3") {
    assert(MaxPointsOnLine.maxPoints(Array(new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151))) == 2)
  }

  test("sample4") {
    assert(MaxPointsOnLine.maxPoints(Array(new Point(0, 0), new Point(1, 1), new Point(1, -1))) == 2)
  }
}
