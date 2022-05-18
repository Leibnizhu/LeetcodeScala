package leetcode.daily

import scala.annotation.tailrec

/**
  * 2022-05-18
  * {@see <a href='https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/'/> }
  */
object KthSmallestNumberInMultiplicationTable {
  /**
    * 首先排除暴力法，m 和 n 的范围在 [1, 30000] 之间，内存会炸的
    * 每一行每一列都是单调增的，所以可以二分法，每一行里找不大于x的数，不大于x的数的个数< k时，x就是结果
    * 显然第i行里，大于x的个数是 min(x/i, n) (最大整行都小于x，就是n个)
    * 然后用二分法在找这个x
    */
  def findKthNumber(m: Int, n: Int, k: Int): Int = {
    //不大于x的数的个数
    def smallerCount(x: Int): Int =
      (1 to m).map(i => math.min(x / i, n)).sum

    @tailrec
    def binaryFind(low: Int, high: Int): Int = {
      if (low < high) {
        val mid = (low + high) / 2
        //不大于mid的数字个数比k大，说明mid是第y小的数字，y>k,继续左区间搜索
        //注意边界，count=k的时候，mid不一定在乘法表中，不能退出。
        // 此时第k小可能小于mid，要继续左区间搜索，找count=k的最小mid
        if (smallerCount(mid) >= k)
          binaryFind(low, mid)
        else
          binaryFind(mid + 1, high)
      } else { //low大于等于high，第k小的数可能出现多次
        low
      }
    }

    // m*n 乘法表范围 [1,m*n]
    binaryFind(1, m * n + 1)
  }
}
