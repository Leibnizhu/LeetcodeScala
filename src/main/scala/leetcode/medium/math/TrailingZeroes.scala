package leetcode.medium.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/113/
  *
  * 给定一个整数 n，返回 n! 结果尾数中零的数量。
  * 说明: 你算法的时间复杂度应为 O(log n) 。
  */
object TrailingZeroes {
  /**
    * 显然不能暴力算
    * 显然是相乘的数存在2和5导致了尾数0
    * 显然阶乘的时候, 因数分解中2的个数远多于5的个数,那么尾数0的个数==阶乘各数的因数分解后5的个数
    * 由此题目等价于求阶乘各数的因数分解5的总次数.
    * 因数分解有5的有m种数, 分别是 [1,k1]*pow(5,1),[1,k2]*pow(5,2),...,[1,km]*pow(5,m)
    * 这样的数分别提供了1,2,...,m个5,因此出现 k1+2*k2+...+m*km个尾数0
    * 考虑到要求复杂度应为 O(log n),可以实现log5(n)
    * 即[1,km]*pow(5,m)其实在[1,ki]*pow(5,i) ,i < m都已经贡献过5,我们只要求每一层相加即可
    */
  def trailingZeroes(n: Int): Int = {
    if (n == 0) 0 else n / 5 + trailingZeroes(n / 5)
  }
}
