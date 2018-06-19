package leetcode.medium.sortsearch

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/103/
  *
  * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
  * 每行的元素从左到右升序排列。
  * 每列的元素从上到下升序排列。
  */
object SearchSortedMatrix {
  /**
    * 根据题目的矩阵排序特性
    * 我们可以从左下角开始
    * 如果当前值比target小,那么整列都比target小, 因此找更大的一列,y++
    * 如果当前值比target大,那么整行都比target大,因此找更小的一列,x--
    * 直到找到(true),或者越界(false)
    * 时间复杂度O(m+n),空间O(1)
    */
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix == null || matrix.isEmpty || matrix(0).isEmpty)
      false
    else {
      def recursive(matrix: Array[Array[Int]], x: Int, y: Int): Boolean = {
        val m = matrix.length // 高,对应x
        val n = matrix(0).length //宽,对应y
        if (x < 0 || x >= m || y < 0 || y >= n)
          false
        else if (matrix(x)(y) == target)
          true
        else if (matrix(x)(y) > target)
          recursive(matrix, x - 1, y) //整行都比target大,因此找更小的一列,x--
        else
          recursive(matrix, x, y + 1) //整列都比target小, 因此找更大的一列
      }
      recursive(matrix, matrix.length -1 , 0)
    }
  }
}
