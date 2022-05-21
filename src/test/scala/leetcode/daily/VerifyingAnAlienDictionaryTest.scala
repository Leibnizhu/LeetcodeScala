package leetcode.daily

import org.scalatest.funsuite.AnyFunSuite

class VerifyingAnAlienDictionaryTest extends AnyFunSuite {
  test("case1") {
    assertResult(true)(VerifyingAnAlienDictionary.isAlienSorted(Array("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
  }

  test("case2") {
    assertResult(false)(VerifyingAnAlienDictionary.isAlienSorted(Array("word", "world", "row"), "worldabcefghijkmnpqstuvxyz"))
  }

  test("case3") {
    assertResult(false)(VerifyingAnAlienDictionary.isAlienSorted(Array("apple", "app"), "abcdefghijklmnopqrstuvwxyz"))
  }
}
