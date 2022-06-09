package codewars.kyu4

import org.scalatest.Assertions.assertResult
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite

class LongestCommonSubsequencePerformanceVersionTest extends AnyFlatSpec {
  it should "pass fixed tests" in {
    assertResult("")(LongestCommonSubsequencePerformanceVersion.lcs("", ""))
    assertResult("")(LongestCommonSubsequencePerformanceVersion.lcs("abc", ""))
    assertResult("")(LongestCommonSubsequencePerformanceVersion.lcs("", "abc"))
    assertResult("")(LongestCommonSubsequencePerformanceVersion.lcs("a", "b"))
    assertResult("a")(LongestCommonSubsequencePerformanceVersion.lcs("a", "a"))
    assertResult("ac")(LongestCommonSubsequencePerformanceVersion.lcs("abc", "ac"))
    assertResult("abc")(LongestCommonSubsequencePerformanceVersion.lcs("abcdef", "abc"))
    assertResult("acf")(LongestCommonSubsequencePerformanceVersion.lcs("abcdef", "acf"))
    assertResult("nottest")(LongestCommonSubsequencePerformanceVersion.lcs("anothertest", "notatest"))
    assertResult("12356")(LongestCommonSubsequencePerformanceVersion.lcs("132535365", "123456789"))
    assertResult("final")(LongestCommonSubsequencePerformanceVersion.lcs("nothardlythefinaltest", "zzzfinallyzzz"))
    assertResult("acdefghijklmnoq")(LongestCommonSubsequencePerformanceVersion.lcs("abcdefghijklmnopq", "apcdefghijklmnobq"))
  }

  it should "not out of bound " in {
    LongestCommonSubsequencePerformanceVersion.lcs("@@1L4L7FM6E<<:6@B:<K",">;G@7>@=;Q:PPEQ16CS0")
    LongestCommonSubsequencePerformanceVersion.lcs("9FSQJLLAHO90<0MR4OPQO6P>R3PPAA3HS1PP<Q6A","MPKPMH>L2RAFB45GF6A7>2N3753HMHGL89PJ7;31")
  }
}
