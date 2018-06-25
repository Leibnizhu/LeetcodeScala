package leetcode.medium.dynamic

import org.scalatest.FunSuite

class CoinChangeTest extends FunSuite{
  test("[1,2,5], 11"){
    assert(CoinChange.coinChange(Array(1,2,5), 11) == 3)
  }

  test("[1,2,5], 23"){
    assert(CoinChange.coinChange(Array(1,2,5), 23) == 6)
  }

  test("[2], 3"){
    assert(CoinChange.coinChange(Array(2), 3) == -1)
  }

  test("[2], 7"){
    assert(CoinChange.coinChange(Array(2), 7) == -1)
  }
}
