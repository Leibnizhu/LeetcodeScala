package codewars.kyu1

import org.scalatest.funsuite.AnyFunSuite

class RegularExpressionForBinaryNumbersDivisibleByNTest extends AnyFunSuite {
  test("case1") {
    assertResult("(0|1)*")(RegularExpressionForBinaryNumbersDivisibleByN.regexDivisibleBy(1))
    assertResult("^(0|11*0)+$")(RegularExpressionForBinaryNumbersDivisibleByN.regexDivisibleBy(2))
    assertResult("^((0|11)|10(1|00)*01)+$")(RegularExpressionForBinaryNumbersDivisibleByN.regexDivisibleBy(3))
    assertResult("^((0|10(10)*0)|(11|10(10)*11)(1|0(10)*11)*0(10)*0)+$")(RegularExpressionForBinaryNumbersDivisibleByN.regexDivisibleBy(4))
    assertResult("^(((0|101)|11(01)*((1|00)1))|(100|11(01)*((1|00)0))(1|0(01)*((1|00)0))*(0(01)*((1|00)1)))+$")(RegularExpressionForBinaryNumbersDivisibleByN.regexDivisibleBy(5))
  }
}
