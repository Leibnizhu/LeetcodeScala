package codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec

class JohnSndAnnSignUpForCodewarsTest extends AnyFlatSpec {
  it should "pass basic tests John" in {
    testJohn(11, "0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6")
  }
  it should "pass basic tests Ann" in {
    testAnn(6, "1, 1, 2, 2, 3, 3")
  }
  it should "pass basic tests sumAnn" in {
    testSumAnn(115, 4070)
    testSumAnn(150, 6930)
  }
  it should "pass basic tests sumJohn" in {
    testSumJohn(30, 269)
    testSumJohn(75, 1720)
  }


  private def testJohn(n: Long, res: String): Unit = {
    println("N: " + n)
    val actual: String = JohnSndAnnSignUpForCodewars.john(n)
    assertResult(res){actual}
  }

  private def testAnn(n: Long, res: String): Unit = {
    println("N: " + n)
    val actual: String = JohnSndAnnSignUpForCodewars.ann(n)
    assertResult(res){actual}
  }

  private def testSumAnn(n: Long, res: Long): Unit = {
    println("N: " + n)
    val actual: Long = JohnSndAnnSignUpForCodewars.sumAnn(n)
    assertResult(res){actual}
  }

  private def testSumJohn(n: Long, res: Long): Unit = {
    println("N: " + n)
    val actual: Long = JohnSndAnnSignUpForCodewars.sumJohn(n)
    assertResult(res){actual}
  }
}
