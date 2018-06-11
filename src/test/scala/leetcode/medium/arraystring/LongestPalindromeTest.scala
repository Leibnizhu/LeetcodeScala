package leetcode.medium.arraystring

import org.scalatest.FunSuite

class LongestPalindromeTest extends FunSuite{
    test("babad"){
      val result = LongestPalindrome.longestPalindrome("babad")
      assert(result.equals("bab") || result.equals("aba"))
    }

  test("cbbd"){
    val result = LongestPalindrome.longestPalindrome("cbbd")
    assert(result.equals("bb") || result.equals("bb"))
  }
}
