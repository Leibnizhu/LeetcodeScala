package leetcode.primary.math

import org.scalatest.funsuite.AnyFunSuite

class CountPrimesTest extends AnyFunSuite{

  /**
    * 输入: 10
    * 输出: 4
    * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
    */
  test("10"){
    assert(CountPrimes.countPrimes(10) == 4)
  }

  test("11"){
    assert(CountPrimes.countPrimes(11) == 4)
  }

  test("12"){
    assert(CountPrimes.countPrimes(12) == 5)
  }
}
