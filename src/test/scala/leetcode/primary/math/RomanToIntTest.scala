package leetcode.primary.math

import org.scalatest.funsuite.AnyFunSuite

class RomanToIntTest extends AnyFunSuite{
  test("III"){
    assert(RomanToInt.romanToInt("III") == 3)
  }

  test("IV"){
    assert(RomanToInt.romanToInt("IV") == 4)
  }

  test("IX"){
    assert(RomanToInt.romanToInt("IX") == 9)
  }

  test("LVIII"){
    assert(RomanToInt.romanToInt("LVIII") == 58)
  }

  test("MCMXCIV"){
    assert(RomanToInt.romanToInt("MCMXCIV") == 1994)
  }

  test("MDCXCIV"){
    assert(RomanToInt.romanToInt("MDCXCIV") == 1694)
  }

  test("error F"){
    assert(RomanToInt.romanToInt("FFF") == 0)
  }
}
