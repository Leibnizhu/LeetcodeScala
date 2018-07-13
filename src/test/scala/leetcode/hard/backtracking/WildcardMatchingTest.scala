package leetcode.hard.backtracking

import org.scalatest.FunSuite

class WildcardMatchingTest extends FunSuite {
  test("a 无法匹配 aa 整个字符串。") {
    assert(!WildcardMatching.isMatch("aa", "a"))
  }

  test("aa,aa") {
    assert(WildcardMatching.isMatch("aa", "aa"))
  }

  test("'*' 可以匹配任意字符串。") {
    assert(WildcardMatching.isMatch("aa", "*"))
  }

  test("aa,a*") {
    assert(WildcardMatching.isMatch("aa", "a*"))
  }

  test("ab,?*") {
    assert(WildcardMatching.isMatch("ab", "?*"))
  }

  test("ab,aa*") {
    assert(!WildcardMatching.isMatch("ab", "aa*"))
  }

  test("'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。") {
    assert(!WildcardMatching.isMatch("cb", "?a"))
  }

  test("第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 dce.") {
    assert(WildcardMatching.isMatch("adceb", "*a*b"))
  }

  test("false") {
    assert(!WildcardMatching.isMatch("acdcb", "a*c?b"))
  }
}
