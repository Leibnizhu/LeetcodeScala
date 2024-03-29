package leetcode.hard.arraystring

import org.scalatest.funsuite.AnyFunSuite

class MinimumWindowSubstringTest extends AnyFunSuite{
  test("S = ADOBECODEBANC, T = ABC"){
    assert(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC") == "BANC")
  }

  test("S = ADOBECODEBANC, T = ABCDENO"){
    assert(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABCDENO") == "CODEBAN")
  }

  test("S = ADOBECODEBANC, T = ABCDENOP"){
    assert(MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABCDENOP") == "")
  }

  test("S = CODEBAN, T = ABCDENO"){
    assert(MinimumWindowSubstring.minWindow("CODEBAN", "ABCDENO") == "CODEBAN")
  }
}
