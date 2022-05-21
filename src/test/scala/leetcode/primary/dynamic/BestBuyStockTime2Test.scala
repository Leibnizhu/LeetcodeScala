package leetcode.primary.dynamic

import org.scalatest.funsuite.AnyFunSuite

class BestBuyStockTime2Test extends AnyFunSuite{

  /**
    * 官方例子1
    */
  test("7,1,5,3,6,4"){
    assert(BestBuyStockTime2.maxProfit(Array(7,1,5,3,6,4)) == 5)
  }

  /**
    * 官方例子2
    */
  test("7,6,4,3,1"){
    assert(BestBuyStockTime2.maxProfit(Array(7,6,4,3,1)) == 0)
  }

  /**
    * 最优买入点不是最低价点
    */
  test("3,7,1,2,3"){
    assert(BestBuyStockTime2.maxProfit(Array(3,7,1,2,3)) == 4)
  }

  test("3"){
    assert(BestBuyStockTime2.maxProfit(Array(3)) == 0)
  }

  test("empty"){
    assert(BestBuyStockTime2.maxProfit(Array[Int]()) == 0)
  }
}
