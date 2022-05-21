package leetcode.primary.string

import org.scalatest.funsuite.AnyFunSuite

class JudgeAnagramTest extends AnyFunSuite {

  test("anagram,nagaram") {
    check("anagram", "nagaram",shouldBe = true)
  }

  test("rat,cat") {
    check("rat", "cat",shouldBe = false)
  }

  test("a,a") {
    check("a", "a",shouldBe = true)
  }

  test("a,ab") {
    check("a", "ab",shouldBe = false)
  }

  private def check(str1: String, str2:String, shouldBe:Boolean) = {
    val result = JudgeAnagram.isAnagram(str1, str2)
    assert(result == shouldBe)
  }

}
