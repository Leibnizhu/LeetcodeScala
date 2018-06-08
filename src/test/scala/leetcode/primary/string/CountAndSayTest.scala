package leetcode.primary.string

import org.scalatest.FunSuite

class CountAndSayTest extends FunSuite {

  test("1") {
    check(1,"1")
  }

  test("2") {
    check(2,"11")
  }

  test("3") {
    check(3,"21")
  }

  test("4") {
    check(4,"1211")
  }

  test("5") {
    check(5,"111221")
  }

  test("6") {
    check(6,"312211")
  }

  test("7") {
    check(7,"13112221")
  }

  private def check(num: Int, shouldBe:String) = {
    val result = CountAndSay.countAndSay(num)
    assert(result.equals(shouldBe))
  }
}
