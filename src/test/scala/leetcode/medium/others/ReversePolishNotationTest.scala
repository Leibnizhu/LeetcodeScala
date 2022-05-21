package leetcode.medium.others

import org.scalatest.funsuite.AnyFunSuite

class ReversePolishNotationTest extends AnyFunSuite {
  test("((2 + 1) * 3) = 9") {
    assert(ReversePolishNotation.evalRPN(Array("2", "1", "+", "3", "*")) == 9)
  }

  test("(4 + (13 / 5)) = 6") {
    assert(ReversePolishNotation.evalRPN(Array("4", "13", "5", "/", "+")) == 6)
  }

  test("((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22") {
    assert(ReversePolishNotation.evalRPN(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")) == 22)
  }

  test("4 -3 = 1") {
    assert(ReversePolishNotation.evalRPN(Array("4", "3", "-")) == 1)
  }
}
