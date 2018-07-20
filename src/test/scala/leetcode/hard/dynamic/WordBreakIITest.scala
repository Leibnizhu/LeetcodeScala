package leetcode.hard.dynamic

import org.scalatest.FunSuite

class WordBreakIITest extends FunSuite {
  test("sample1") {
    val res = WordBreakII.wordBreak("catsanddog", List("cat", "cats", "and", "sand", "dog"))
    assert(res.sorted == List("cats and dog", "cat sand dog").sorted)
  }

  test("sample2") {
    val res = WordBreakII.wordBreak("pineapplepenapple", List("apple", "pen", "applepen", "pine", "pineapple"))
    assert(res.sorted == List("pine apple pen apple", "pineapple pen apple", "pine applepen apple").sorted)
  }

  test("sample3") {
    val res = WordBreakII.wordBreak("catsandog", List("cats", "dog", "sand", "and", "cat"))
    assert(res isEmpty)
  }
}
