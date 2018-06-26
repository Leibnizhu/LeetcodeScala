package leetcode.hard.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/125/
  *
  * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
  * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
  */
object FourSumII {
  /**
    * 直接穷尽时间复杂度是4次幂,估计会超时
    * 可以把数组分两组,A+B和C+D,A+B先求和放入hash O(N*N)时间
    * 然后C+D遍历求和 O(N*N)时间,求和的时候去hash里面查是否存在相反数(O(1)时间),存在即和为0
    * 此时总时间复杂度是2次幂
    */
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    // A+B求和,然后统计求和值的频次,转成Map
    val abSum = (for {a <- A; b <- B} yield a + b).groupBy(p => p).map(p => (p._1, p._2.length))
    // C+D求和, 每个求和值去A+B求和的哈希里面查找反数,找到的次数求和
    (for {c <- C; d <- D} yield c + d).map(s => abSum.getOrElse(-s, 0)).sum
  }
}
