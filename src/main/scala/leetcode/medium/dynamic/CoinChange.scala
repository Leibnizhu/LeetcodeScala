package leetcode.medium.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/106/
  *
  * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
  */
object CoinChange {
  /**
    * 典型动态规划.
    * 最直接的想法是,每个amount的最小硬币个数f(x),去找所有可能的组合可能去找最小值,即:
    * f(x) = min(f(1)+f(x-1), ...,f(x/2)+f(x/2))
    * 但实际上可以优化,因为想找最小的组合个数, 只要找coins个数次数就行,每次拿coins的一个面值,剩下的去备忘录里找即:
    * f(x) =  min(1+f(x-coins(0),...,1+f(x-coins.last))
    */
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val memo = Array.fill(amount + 1)(amount + 1) //备忘录,初始化为amount+1这样保证在计算min的时候正确
    memo(0) = 0
    for {
      i <- 1 to amount //遍历填充备忘录
      j <- coins.indices //遍历硬币可用面额
    } yield if (coins(j) <= i) memo(i) = Math.min(memo(i), 1 + memo(i - coins(j)))
    if (memo.last == amount + 1) -1 else memo.last //如果找不到解,那么保持着初始化状态的amount+1,则返回-1
  }
}
