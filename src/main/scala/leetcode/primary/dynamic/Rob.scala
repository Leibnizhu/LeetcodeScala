package leetcode.primary.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/57/
  *
  * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
  * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
  * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
  */
object Rob {
  /**
    * 只有一家的时候选第一家,没其他选择
    * 有两家的时候,选择金额较大的那一家
    * 第n家的时候,有两个选择,偷或不偷,偷的话,上一家不能偷,收益=上两家+这一家,假设收益为f(n),则这个选择的收益是f(n-2)+num(n)
    * 不偷的话,偷的钱是上一家的f(n-1)
    * 即f(n)=max(f(n-2)+nums(n) ,f(n-1))
    */
  def rob(nums: Array[Int]): Int = {
    if (nums.isEmpty) {
      0
    } else if (nums.length == 1) { //只有一家的时候选第一家
      nums.head
    } else {
      var prevPrev = nums.head //上上一家
      var prev = Math.max(nums(0), nums(1)) //上一家
      var cur = prev
      for (i <- 2 until nums.length) {
        cur = Math.max(nums(i) + prevPrev, prev)
        prevPrev = prev
        prev = cur
      }
      cur
    }
  }

}
