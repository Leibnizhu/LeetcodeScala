package codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SquareIntoSquaresTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    dotest(2, null);
    dotest(11, "1 2 4 10");
    dotest(12, "1 2 3 7 9");
    dotest(625, "2 5 8 34 624");
    dotest(7100, "2 3 5 119 7099");
    dotest(12345, "2 6 157 12344");
    dotest(1234567, "2 8 32 1571 1234566");
  }

  private def isSorted(s: String): Boolean = {
    val a = s.split(' ').map(_.trim.toLong)
    if (a.length < 2) return false
    for (i <- 0 until a.length - 1 if a(i) >= a(i + 1)) {
      return false
    }
    true
  }

  private def total(s: String, m: Long): Boolean = {
    var i: Int = 0
    val a = s.split(' ').map(_.trim.toLong)
    var sum: Long = 0
    i = 0
    while (i < a.length) {
      sum += a(i) * a(i)
      i += 1
    }
    if (sum == m) true else false
  }

  private def dotest(n: Long, sexp: String): Unit = {
    var success: Boolean = false
    val sact: String = SquareIntoSquares.decompose(n)
    var st: Boolean = false
    var t: Boolean = false
    println("Expected " + sexp + "; got " + sact)
    if (((sact == null) && (sexp == null)) || ((sact != null) && (sact == sexp))) {
      println("GOOD")
      success = true
    } else {
      if (sact == null) {
        success = false
      } else {
        st = isSorted(sact)
        t = total(sact, n * n)
        if ((st == false) || (t == false)) {
          println("** Error. Not increasinly sorted or bad sum of squares **")
          success = false
        } else {
          println("GOOD; Increasing and total correct")
          success = true
        }
      }
    }
    assertResult(true) {
      success
    }
  }
}