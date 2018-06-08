package leetcode.primary.others

import org.scalatest.FunSuite

class IsValidBracketsTest extends FunSuite{
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
