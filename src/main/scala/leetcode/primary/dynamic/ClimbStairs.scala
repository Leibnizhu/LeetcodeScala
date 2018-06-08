package leetcode.primary.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
  *
  * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
  * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
  * 注意：给定 n 是一个正整数。
  */
object ClimbStairs {
  /**
    * 从走楼梯最后一步来看,最后一步要么是2个台阶要么1个台阶,
    * 假定n个台阶有f(n)重走法,那么最后一步走2个台阶的话,有f(n-2)种走法,最后一步走1个台阶的话有f(n-1)种走法
    * 也就是说f(n)=f(n-1)+f(n-2), 显然就是斐波拉契数列, 初始条件:f(1)=1,f(2)=2,相当于f(0)=1
    * 可以用递归,但是斐波拉契不能直接尾递归,要是测试用例有比较大的n那就跪了,而且这里是动态规划的章节,所以自底向上动态规划,
    */
  def climbStairs(n: Int): Int = {
    var prev = 0
    var cur = 1
    for(i <- 0 until n){
      val tmp = cur
      cur=prev+cur
      prev = tmp
    }
    cur
  }
}
