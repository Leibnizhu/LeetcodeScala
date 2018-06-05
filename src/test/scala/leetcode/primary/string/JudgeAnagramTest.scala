package leetcode.primary.string

import org.scalatest.FunSuite

class JudgeAnagramTest extends FunSuite {

  test("anagram,nagaram") {
    check("anagram", "nagaram",true)
  }

  test("rat,cat") {
    check("rat", "cat",false)
  }

  test("a,a") {
    check("a", "a",true)
  }

  private def check(str1: String, str2:String, shouldBe:Boolean) = {
    val result = JudgeAnagram.isAnagram(str1, str2)
    assert(result == shouldBe)
  }

}
