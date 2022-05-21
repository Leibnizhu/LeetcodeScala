package leetcode.primary.string

import org.scalatest.funsuite.AnyFunSuite

class ReverseIntegerTest extends AnyFunSuite {

  test("123") {
    check(123, 321)
  }

  test("-123") {
    check(-123, -321)
  }

  test("120") {
    check(120, 21)
  }

  test("0") {
    check(0, 0)
  }

  test("1") {
    check(1, 1)
  }

  test("2") {
    check(2, 2)
  }

  test("10") {
    check(10, 1)
  }

  test("1000000009") {
    check(1000000009, 0)
  }

  test("1463847412") {
    check(1463847412, 2147483641)
  }

  private def check(num: Int, shouldBe:Int) = {
    val result = ReverseInteger.reverse(num)
    assert(result == shouldBe)
  }
}
