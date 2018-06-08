package leetcode.primary.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/55/
  *
  * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
  * 注意你不能在买入股票前卖出股票。
  */
object BestBuyStockTime2 {
  /**
    * 只允许买一次,必须先买后买,那么只能在低点买入,高点卖出
    * 也就是说可以将价格数组分成前后两个子数组,买入点是前缀的最小值,卖出点是后缀的最大值
    * 这样的收益的最大值就是本题的解.
    * 要用动态规划,考虑到最大最小值的特性(可以线性增量计算),同时我们要得到所有前缀的最小值和所有后缀的最大值
    * 因此可以用数组把这两个存起来,最小值数组从左边开始算,最大值数组从右边开始算
    */
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.length <= 1) {
      0
    } else {
      var curMin = prices.head
      val min = prices.map(price => { //保存从左边开始往右依次的最小值
        if (price < curMin) curMin = price
        curMin
      })
      var curMax = prices.last
      val max = prices.reverse.map(price => { //保存从右边开始往左依次的最大值
        if (price > curMax) curMax = price
        curMax
      }).reverse
      max.zip(min).map(p => p._1 - p._2).max //两边相减就是收益,取收益最大值返回
    }
  }
}
