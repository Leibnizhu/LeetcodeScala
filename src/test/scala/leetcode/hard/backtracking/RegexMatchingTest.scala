package leetcode.hard.backtracking

import org.scalatest.funsuite.AnyFunSuite

class RegexMatchingTest extends AnyFunSuite {
  test("a 无法匹配 aa 整个字符串") {
    assert(!RegexMatching.isMatch("a", "aa"))
  }

  test("'*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 aa") {
    assert(RegexMatching.isMatch("aa", "a*"))
  }

  test(".* 表示可匹配零个或多个('*')任意字符('.')") {
    assert(RegexMatching.isMatch("ab", ".*"))
  }

  test("'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 aab") {
    assert(RegexMatching.isMatch("aab", "c*a*b"))
  }

  test("mississippi, mis*is*p*.") {
    assert(!RegexMatching.isMatch("mississippi", "mis*is*p*."))
  }

  test("ab, .*c") {
    assert(!RegexMatching.isMatch("ab", ".*c"))
  }
}
