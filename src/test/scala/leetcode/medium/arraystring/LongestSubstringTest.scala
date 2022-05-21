package leetcode.medium.arraystring

import org.scalatest.funsuite.AnyFunSuite

class LongestSubstringTest extends AnyFunSuite{
  test("abcabcbb"){
    assert(LongestSubstring.lengthOfLongestSubstring("abcabcbb") == 3)
  }

  test("bbbbb"){
    assert(LongestSubstring.lengthOfLongestSubstring("bbbbb") == 1)
  }

  test("pwwkew"){
    assert(LongestSubstring.lengthOfLongestSubstring("pwwkew") == 3)
  }

  test("empty"){
    assert(LongestSubstring.lengthOfLongestSubstring("") == 0)
  }
}
