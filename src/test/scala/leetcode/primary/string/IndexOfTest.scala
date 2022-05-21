package leetcode.primary.string

import org.scalatest.funsuite.AnyFunSuite

class IndexOfTest extends AnyFunSuite {

  test("hello, ll") {
    check("hello", "ll",2)
  }

  test("aaaaa, bba") {
    check("aaaaa", "bba",-1)
  }

  /**
    * 当 needle 是空字符串时我们应当返回 0
    */
  test("aaaaa, empty string") {
    check("aaaaa", "",0)
  }

  test("long"){
    check("ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb", "abbabbbabaa", 92)
  }

  private def check(src: String, target:String, shouldBe:Int) = {
    val result = IndexOf.strStr(src,target)
    assert(result == shouldBe)
  }

}
