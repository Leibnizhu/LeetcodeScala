package leetcode.hard.backtracking

import org.scalatest.funsuite.AnyFunSuite

class RemoveInvalidParenthesesTest extends AnyFunSuite {
  test("()())()") {
    assert(RemoveInvalidParentheses.removeInvalidParentheses("()())()").sorted == List("()()()", "(())()").sorted)
  }

  test("(a)())()") {
    assert(RemoveInvalidParentheses.removeInvalidParentheses("(a)())()").sorted == List("(a)()()", "(a())()").sorted)
  }

  test(")(") {
    assert(RemoveInvalidParentheses.removeInvalidParentheses(")(") == List(""))
  }
}
