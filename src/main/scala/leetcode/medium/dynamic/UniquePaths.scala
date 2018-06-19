package leetcode.medium.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/51/dynamic-programming/105/
  *
  * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
  * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
  * 问总共有多少条不同的路径？
  * 说明：m 和 n 的值均不超过 100。
  */
object UniquePaths {
  /**
    * 动态规划
    * 每个格子可达路径数=其上方格子可达路径数+其左方格子可达路径数
    * 即:
    * f(x,y) = f(x-1,y)+f(x,y-1), x>0 && y>0
    * f(x,y) = f(x,y-1), x==0 && y>0
    * f(x,y) = f(x-1,y), x>0 && y==0
    * f(x,y) = 1, x==0 && y==0
    */
  def uniquePaths(m: Int, n: Int): Int = {
    val f = Array.ofDim[Int](m, n)
    for {
      x <- 0 until m
      y <- 0 until n
    } yield if (x == 0 && y == 0) f(x)(y) = 1
    else if (x == 0 && y > 0) f(x)(y) = f(x)(y - 1)
    else if (x > 0 && y == 0) f(x)(y) = f(x - 1)(y)
    else f(x)(y) = f(x - 1)(y) + f(x)(y - 1)
    f(m - 1)(n - 1)
  }
}
