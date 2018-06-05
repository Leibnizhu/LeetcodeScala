package leetcode.primary.string

import org.scalatest.FunSuite

class JudgePalindromeTest extends FunSuite {

  test("A man, a plan, a canal: Panama") {
    check("A man, a plan, a canal: Panama", true)
  }

  test("race a car") {
    check("race a car",false)
  }

  test("aaaa") {
    check("aaaa",true)
  }

  test("empty") {
    check("   ",true)
  }

  private def check(str: String, shouldBe:Boolean) = {
    val result = JudgePalindrome.isPalindrome(str)
    assert(result == shouldBe)
  }

}
