package leetcode.hard.arraystring

import org.scalatest.FunSuite

class CalculatorTest extends FunSuite{
  test("3+2*2"){
    assert(Calculator.calculate("3+2*2") == 7)
  }

  test(" 3/2 "){
    assert(Calculator.calculate(" 3/2 ") == 1)
  }

  test(" 3+5 / 2 "){
    assert(Calculator.calculate(" 3+5 / 2 ") == 5)
  }

  test(" 35 / 2 - 3 "){
    assert(Calculator.calculate(" 35 / 2 - 3 ") == 14)
  }
}
