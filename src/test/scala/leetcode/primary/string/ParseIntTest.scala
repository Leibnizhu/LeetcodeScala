package leetcode.primary.string

import org.scalatest.FunSuite

class ParseIntTest extends FunSuite {

  test("42") {
    check("42",42)
  }

  /**
    * 输入: "   -42"
    * 输出: -42
    * 解释: 第一个非空白字符为 '-', 它是一个负号。
    * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
    */
  test("   -42") {
    check("   -42",-42)
  }

  /**
    * 输入: "4193 with words"
    * 输出: 4193
    * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
    */
  test("4193 with words") {
    check("4193 with words",4193)
  }

  /**
    * 输入: "-91283472332"
    * 输出: -2147483648
    * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
    * 因此返回 INT_MIN (−231) 。
    */
  test("-91283472332") {
    check("-91283472332",-2147483648)
  }

  test("91283472332") {
    check("91283472332",Integer.MAX_VALUE)
  }

  test("-2147483647") {
    check("-2147483647", -2147483647)
  }

  test("-2147483648") {
    check("-2147483648", -2147483648)
  }

  test("-2147483649") {
    check("-2147483649", -2147483648)
  }

  test("2147483647") {
    check("2147483647", 2147483647)
  }

  test("2147483648") {
    check("2147483648", 2147483647)
  }

  test("0") {
    check("0",0)
  }

  test("10") {
    check("10",10)
  }

  test("+") {
    check("+",0)
  }

  test("-") {
    check("-",0)
  }

  test("x") {
    check("x",0)
  }

  test(" ") {
    check(" ",0)
  }

  private def check(str: String, shouldBe:Int) = {
    val result = ParseInt.myAtoi(str)
    assert(result == shouldBe)
  }
}
