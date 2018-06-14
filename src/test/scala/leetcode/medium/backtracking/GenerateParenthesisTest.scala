package leetcode.medium.backtracking

import org.scalatest.FunSuite

class GenerateParenthesisTest extends FunSuite {
  test("0") {
    check(0, List())
  }

  test("1") {
    check(1, List("()"))
  }

  test("2") {
    check(2, List("(())", "()()"))
  }

  test("3") {
    check(3, List("((()))", "(()())", "(())()", "()(())", "()()()"))
  }

  private def check(num: Int, shouldBe: List[String]) = {
    val result = GenerateParenthesis.generateParenthesis(num)
    assert(result.sorted == shouldBe.sorted)
  }
}
