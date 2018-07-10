package leetcode.hard.backtracking

import org.scalatest.FunSuite

class PalindromePartitioningTest extends FunSuite {
  test("aab") {
    assert(PalindromePartitioning.partition("aab") ==
      List(List("aa", "b"), List("a", "a", "b")))
  }

  test("aa") {
    assert(PalindromePartitioning.partition("aa") ==
      List(List("aa"), List("a", "a")))
  }

  test("empty") {
    assert(PalindromePartitioning.partition("") == List(List()))
  }

  test("aabbaa") {
    assert(PalindromePartitioning.partition("aabbaa") == List(
      List("aabbaa"),
      List("aa", "bb", "aa"),
      List("a", "a", "bb", "aa"),
      List("aa", "b", "b", "aa"),
      List("a", "a", "b", "b", "aa"),
      List("a", "abba", "a"),
      List("aa", "bb", "a", "a"),
      List("a", "a", "bb", "a", "a"),
      List("aa", "b", "b", "a", "a"),
      List("a", "a", "b", "b", "a", "a")))
  }
}
