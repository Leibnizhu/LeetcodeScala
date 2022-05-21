package leetcode.primary.others

import org.scalatest.funsuite.AnyFunSuite

class IsValidBracketsTest extends AnyFunSuite{
  test("()"){
    assert(IsValidBrackets.isValid("()"))
  }

  test("()[]{}"){
    assert(IsValidBrackets.isValid("()[]{}"))
  }

  test("(]"){
    assert(!IsValidBrackets.isValid("(]"))
  }

  test("([)]"){
    assert(!IsValidBrackets.isValid("([)]"))
  }

  test("{[]}"){
    assert(IsValidBrackets.isValid("{[]}"))
  }

  test("empty"){
    assert(IsValidBrackets.isValid(""))
  }

  test("("){
    assert(!IsValidBrackets.isValid("("))
  }

  test("]"){
    assert(!IsValidBrackets.isValid("]"))
  }
}
