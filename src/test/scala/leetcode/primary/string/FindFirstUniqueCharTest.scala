package leetcode.primary.string

import org.scalatest.funsuite.AnyFunSuite

class FindFirstUniqueCharTest extends AnyFunSuite {

  test("leetcode") {
    check("leetcode", 0)
  }

  test("loveleetcode") {
    check("loveleetcode", 2)
  }

  test("aaaabcdefghijklmnopqrstuvwxyz") {
    check("aaaabcdefghijklmnopqrstuvwxyz", 4)
  }

  test("abcdefghijklmnopqrstuvwxyzzzz") {
    check("abcdefghijklmnopqrstuvwxyzzzz", 0)
  }

  test("aabbccddeeff") {
    check("aabbccddeeff", -1)
  }

  private def check(str: String, shouldBe:Int) = {
    val result = FindFirstUniqueChar.firstUniqChar(str)
    assert(result == shouldBe)
  }
}
