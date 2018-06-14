package leetcode.medium.backtracking

import org.scalatest.FunSuite

class LetterCombinationsTest extends FunSuite{
  test("23"){
    val result = LetterCombinations.letterCombinations("23")
    println(result)
    assert(result.sorted == List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf").sorted)
  }

  test("null"){
    val result = LetterCombinations.letterCombinations(null)
    assert(result == List())
  }

  test("empty"){
    val result = LetterCombinations.letterCombinations("")
    assert(result == List())
  }
}
