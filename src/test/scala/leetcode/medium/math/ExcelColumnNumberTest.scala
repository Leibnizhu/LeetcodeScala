package leetcode.medium.math

import org.scalatest.FunSuite

class ExcelColumnNumberTest extends FunSuite{
  test("A"){
    assert(ExcelColumnNumber.titleToNumber("A") == 1)
  }

  test("Z"){
    assert(ExcelColumnNumber.titleToNumber("Z") == 26)
  }

  test("AB"){
    assert(ExcelColumnNumber.titleToNumber("AB") == 28)
  }

  test("ZY"){
    assert(ExcelColumnNumber.titleToNumber("ZY") == 701)
  }
}
