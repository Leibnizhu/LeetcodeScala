package leetcode.medium.arraystring

import org.scalatest.funsuite.AnyFunSuite

class LongestPalindromeTest extends AnyFunSuite {
  test("babad") {
    val result = LongestPalindrome.longestPalindrome("babad")
    assert(result.equals("bab") || result.equals("aba"))
  }

  test("cbbd") {
    val result = LongestPalindrome.longestPalindrome("cbbd")
    assert(result.equals("bb"))
  }

  test("eabcb") {
    val result = LongestPalindrome.longestPalindrome("eabcb")
    assert(result.equals("bcb"))
  }

  test("a") {
    val result = LongestPalindrome.longestPalindrome("a")
    assert(result.equals("a"))
  }

  test("empty") {
    val result = LongestPalindrome.longestPalindrome("")
    assert(result.equals(""))
  }
}
