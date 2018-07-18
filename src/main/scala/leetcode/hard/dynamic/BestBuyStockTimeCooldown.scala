package leetcode.hard.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/155/
  *
  * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
  * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
  *  - 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
  *  - 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
  */
object BestBuyStockTimeCooldown {
  /**
    * 比之前的题目增加了冷却期,那么每天的状态有买,卖和冷却,而卖和冷却其实可以合并的
    * 在动态规划的题目类别里,考虑动态规划
    * 用数组buy[i]记录每天若持有股票的最大收益,sell[i]记录每天若不持有股票的最大收益
    * buy:要么不动作,持续昨天的收益,要么(昨天或更早前冷冻过之后今天)买入(收益等于T-2减去今天股价),即:
    * buy[i] = max(buy[i-1], sell[i-2]-price[i])
    * sell:要么不动作,持续昨天收益,要么今天卖出(收益=昨天持股收益加上今天股价),即
    * sell[i] = max(sell[i-1], buy[i-1]+price[i])
    * 遍历价格数组可以得到答案,时间复杂度O(n)
    * 可以看出来,每天只依赖T-1的buy和T-1/T-2的sell,因此数组可以用三个变量替代,做到空间复杂度O(1)
    */
  def maxProfit(prices: Array[Int]): Int =
    if (prices == null || prices.isEmpty) {
      0
    } else {
      var curSell, prevSell = 0 //分别是sell[i-1](对于上一次而言是current),sell[i-2]
      var curBuy = -prices(0) //buy[i-1],第一天买入的话收益为负
      prices.tail.foreach(price => {
        val tmpSell = curSell // 覆盖preSell的时候还要用
        curSell = Math.max(curSell, curBuy + price)
        curBuy = Math.max(curBuy, prevSell - price) //受冷冻期影响,只能拿prevSell
        prevSell = tmpSell
      })
      curSell
    }
}
