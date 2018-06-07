package leetcode.primary.array

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
  *
  * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
  * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
  */
object BestBuyStockTime {
  def maxProfit(prices: Array[Int]): Int = {
    /**
      * 求每两个价格之间的差值,大于0则有收益,加入收益,否则不买卖
      * @param prices 价格曲线
      * @param profit 收益
      * @param i      游标
      */
    def process(prices: Array[Int], profit: Int, i: Int): Int =
      if (i >= prices.length) profit else process(prices, profit + Math.max(prices(i) - prices(i - 1), 0), i + 1)

    if (prices == null || prices.length < 2) 0 else process(prices, 0, 1)
  }
}
