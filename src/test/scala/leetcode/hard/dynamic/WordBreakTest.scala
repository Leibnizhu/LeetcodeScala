package leetcode.hard.dynamic

import org.scalatest.funsuite.AnyFunSuite

class WordBreakTest extends AnyFunSuite {
  test("leetcode 可以被拆分成 leet code") {
    assert(WordBreak.wordBreak("leetcode", List("leet", "code")))
  }

  test("applepenapple 可以被拆分成 apple pen apple。可以重复使用字典中的单词。") {
    assert(WordBreak.wordBreak("applepenapple", List("apple", "pen")))
  }

  test("sample3") {
    assert(!WordBreak.wordBreak("catsandog", List("cats", "dog", "sand", "and", "cat")))
  }
}
