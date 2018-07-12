package leetcode.hard.backtracking

import org.scalatest.FunSuite

class RemoveInvalidParenthesesTest extends FunSuite {
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
