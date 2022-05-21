package leetcode.primary.math

import org.scalatest.funsuite.AnyFunSuite

class IsPowerOfThreeTest extends AnyFunSuite{
  test("27"){
    assert(IsPowerOfThree.isPowerOfThree(27))
  }

  test("1"){
    assert(IsPowerOfThree.isPowerOfThree(1))
  }

  test("0"){
    assert(!IsPowerOfThree.isPowerOfThree(0))
  }

  test("9"){
    assert(IsPowerOfThree.isPowerOfThree(9))
  }

  test("45"){
    assert(!IsPowerOfThree.isPowerOfThree(45))
  }
}
