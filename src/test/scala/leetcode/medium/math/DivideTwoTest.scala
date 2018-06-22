package leetcode.medium.math

import org.scalatest.FunSuite

class DivideTwoTest extends FunSuite {
  test("10 / 3") {
    assert(DivideTwo.divide(10, 3) == 3)
  }

  test("7 / -3") {
    assert(DivideTwo.divide(7, -3) == -2)
  }

  test("minInt / -1") {
    assert(DivideTwo.divide(Int.MinValue, -1) == Int.MaxValue)
  }

  test("minInt / 1") {
    assert(DivideTwo.divide(Int.MinValue, 1) == Int.MinValue)
  }

  test("maxInt / -1") {
    assert(DivideTwo.divide(Int.MaxValue, -1) == Int.MinValue + 1)
  }

  test("maxInt / 1") {
    assert(DivideTwo.divide(Int.MaxValue, 1) == Int.MaxValue)
  }

  test("0 / -1") {
    assert(DivideTwo.divide(0, -1) == 0)
  }

  test("1 / 0") {
    assert(DivideTwo.divide(1, 0) == Int.MaxValue)
  }

  test("-1 / 0") {
    assert(DivideTwo.divide(-1, 0) == Int.MaxValue)
  }

  test("maxInt / 0") {
    assert(DivideTwo.divide(Int.MaxValue, 0) == Int.MaxValue)
  }

  test("minInt / 0") {
    assert(DivideTwo.divide(Int.MinValue, 0) == Int.MaxValue)
  }

  test("minInt / 2") {
    assert(DivideTwo.divide(Int.MinValue, 2) == -1073741824)
  }

  test("minInt / -2") {
    assert(DivideTwo.divide(Int.MinValue, -2) == 1073741824)
  }

  test("maxInt / 2") {
    assert(DivideTwo.divide(Int.MaxValue, 2) == 1073741823)
  }

  test("maxInt / -2") {
    assert(DivideTwo.divide(Int.MaxValue, -2) == -1073741823)
  }

  test("maxInt / minInt") {
    assert(DivideTwo.divide(Int.MaxValue, Int.MinValue) == 0)
  }

  test("minInt / maxInt") {
    assert(DivideTwo.divide(Int.MinValue, Int.MaxValue) == -1)
  }

  test("maxInt / maxInt") {
    assert(DivideTwo.divide(Int.MaxValue, Int.MaxValue) == 1)
  }

  test("minInt / minInt") {
    assert(DivideTwo.divide(Int.MinValue, Int.MinValue) == 1)
  }
}
