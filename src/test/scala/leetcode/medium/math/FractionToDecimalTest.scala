package leetcode.medium.math

import org.scalatest.FunSuite

class FractionToDecimalTest extends FunSuite{
  test("1,2"){
    assert(FractionToDecimal.fractionToDecimal(1,2) == "0.5")
  }

  test("2,1"){
    assert(FractionToDecimal.fractionToDecimal(2,1) == "2")
  }

  test("2,3"){
    assert(FractionToDecimal.fractionToDecimal(2,3) == "0.(6)")
  }

  test("23,7"){
    assert(FractionToDecimal.fractionToDecimal(23,7) == "3.(285714)")
  }

  test("-1,-2147483648"){
    assert(FractionToDecimal.fractionToDecimal(-1, -2147483648) == "0.0000000004656612873077392578125")
  }
}
