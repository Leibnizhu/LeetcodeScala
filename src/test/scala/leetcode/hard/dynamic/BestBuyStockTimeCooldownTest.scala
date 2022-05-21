package leetcode.hard.dynamic

import org.scalatest.funsuite.AnyFunSuite

class BestBuyStockTimeCooldownTest extends AnyFunSuite {
  test("null") {
    assert(BestBuyStockTimeCooldown.maxProfit(null) == 0)
  }

  test("empty") {
    assert(BestBuyStockTimeCooldown.maxProfit(Array()) == 0)
  }

  test("one day") {
    assert(BestBuyStockTimeCooldown.maxProfit(Array(3)) == 0)
  }

  test("1,3") {
    assert(BestBuyStockTimeCooldown.maxProfit(Array(1, 3)) == 2)
  }

  test("3,1") {
    assert(BestBuyStockTimeCooldown.maxProfit(Array(3, 1)) == 0)
  }

  /**
    * 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
    */
  test("1,2,3,0,2") {
    assert(BestBuyStockTimeCooldown.maxProfit(Array(1, 2, 3, 0, 2)) == 3)
  }
}
