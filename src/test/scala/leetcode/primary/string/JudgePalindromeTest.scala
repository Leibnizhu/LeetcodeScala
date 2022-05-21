package leetcode.primary.string

import org.scalatest.funsuite.AnyFunSuite

class JudgePalindromeTest extends AnyFunSuite {

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

  test("null") {
    check(null, shouldBe = false)
  }

  private def check(str: String, shouldBe:Boolean) = {
    val result = JudgePalindrome.isPalindrome(str)
    assert(result == shouldBe)
  }

}
