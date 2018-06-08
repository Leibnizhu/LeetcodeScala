package leetcode.primary.string

import org.scalatest.FunSuite

class LongestCommonPrefixTest extends FunSuite {

  test("flower,flow,flight") {
    check(Array("flower","flow","flight"), "fl")
  }

  test("dog,racecar,car") {
    check(Array("dog","racecar","car"), "")
  }

  test("empty") {
    check(Array(), "")
  }

  test("dog,dog,dog") {
    check(Array("dog","dog","dog"), "dog")
  }

  private def check(strs: Array[String], shouldBe:String) = {
    val result = LongestCommonPrefix.longestCommonPrefix(strs)
    assert(result == shouldBe)
  }
}
