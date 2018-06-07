package leetcode.primary.string

import org.scalatest.FunSuite

class JudgePalindromeTest extends FunSuite {

  test("A man, a plan, a canal: Panama") {
    check("A man, a plan, a canal: Panama", shouldBe = true)
  }

  test("race a car") {
    check("race a car",shouldBe = false)
  }

  test("aaaa") {
    check("aaaa",shouldBe = true)
  }

  test("empty") {
    check("   ",shouldBe = true)
  }

  private def check(str: String, shouldBe:Boolean) = {
    val result = JudgePalindrome.isPalindrome(str)
    assert(result == shouldBe)
  }

}
