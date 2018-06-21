package leetcode.medium.math

import org.scalatest.FunSuite

class PowerTest extends FunSuite{
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
}
