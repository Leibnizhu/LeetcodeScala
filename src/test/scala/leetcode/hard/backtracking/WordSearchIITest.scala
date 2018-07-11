package leetcode.hard.backtracking

import org.scalatest.FunSuite

class WordSearchIITest extends FunSuite {
  test("sample1") {
    val board = Array(
      Array('o', 'a', 'a', 'n'),
      Array('e', 't', 'a', 'e'),
      Array('i', 'h', 'k', 'r'),
      Array('i', 'f', 'l', 'v')
    )
    assert(WordSearchII.findWords(board, Array("oath", "pea", "eat", "rain")).sorted
      == List("eat", "oath").sorted)
    assert(WordSearchII.findWords(board, Array("tei", "aaa", "neakhfi", "xxx", "fhan")).sorted
      == List("tei", "aaa", "neakhfi").sorted)
  }

  test("sample2") {
    val board = Array(
      Array('a', 'b'),
      Array('a', 'a')
    )
    assert(WordSearchII.findWords(board, Array("aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba")).sorted
      == List("aaa", "aaab", "aaba", "aba", "baa").sorted)
  }
}
