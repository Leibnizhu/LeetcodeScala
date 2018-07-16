package leetcode.hard.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/59/sorting-and-searching/152/
  *
  * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
  * 请注意，它是排序后的第k小元素，而不是第k个元素。
  * 说明: 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n*n 。
  */
object KthSmallestInMatrix {
  type Matrix = Array[Array[Int]]

  /**
    * 二分查找,每次对比当前范围比中间值少的个数,如果小于k,左边界优异右移,反之右边界左移
    * 查找小于中间值个数的时候,可以利用矩阵特性,逐行扫,每行从右边开始向左找到第一个小于中间值的,剩下都是小于中间值的
    * 而且,越往下,比中间值小的数越少,所以下一行的开始搜索位置可以从上一行中断的位置开始,最后每一行的结果相加就行
    */
  def kthSmallest(matrix: Matrix, k: Int): Int = {
    val (h, w) = (matrix.length, matrix(0).length)

    def findMid(m: Matrix, k: Int)(left: Int, right: Int): Int = if (left >= right) left else {
      val mid = left + (right - left) / 2
      var j = w - 1 //查找每一行小于mid的个数的游标,从右往左,每一行从上一行结束的位置开始
     (0 until h).map(i => {
        while (j >= 0 && m(i)(j) > mid) j -= 1
        j + 1
      }).sum match {
        case c if c < k => findMid(m, k)(mid + 1, right)
        case _ => findMid(m, k)(left, mid)
      }
    }

    findMid(matrix, k)(matrix(0)(0), matrix(h - 1)(w - 1)) //根据矩阵特性,从最大最小值开始搜索
  }
}
