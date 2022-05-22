package leetcode.medium.math

import org.scalatest.funsuite.AnyFunSuite

class PowerTest extends AnyFunSuite{
  test("2.00000, 10"){
    assert(Power.myPow(2.00000, 10) == 1024.0000)
  }

  test("2.10000, 3"){
    assert(Power.myPow(2.10000, 3) == 9.261000000000001)
  }

  test("2.00000, -2"){
    assert(Power.myPow(2.00000, -2) == 0.25000)
  }

  test("1.00001, 123456"){
    assert(Power.myPow(1.00001, 123456) == 3.4368447520767935)
  }

  test("-1.00001, 123456"){
    assertResult(3.4368447520767935)(Power.myPow(-1.00001, 123456))
  }

  test("-1.00001, 0"){
    assertResult(1)(Power.myPow(-1.00001, 0))
  }
}
