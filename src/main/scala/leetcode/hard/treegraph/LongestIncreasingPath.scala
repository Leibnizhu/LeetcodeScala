package leetcode.hard.treegraph

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/144/
  *
  * 给定一个整数矩阵，找出最长递增路径的长度。
  * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
  */
object LongestIncreasingPath {
  type Matrix = Array[Array[Int]]

  /**
    * 要找最长的路径,考虑dfs,每个点分别dfs.
    * 但是其实很多重复运算,可以结合动态规划,再用一个等大二维数组记录每个点已经计算的最长递增路径,这部分是重复的.
    * dfs的时候找周围的点,如果在备忘录里保存的非0,则该路上取值为附近的点+1
    */
  def longestIncreasingPath(matrix: Matrix): Int = {
    /**
      * 深度优先搜索,在matrix中结合备忘录memo从(i,j)点开始搜索,找当前点四个方向的下一个点,
      * 分别计算其最长递增数组长度(前提是比当前点大),返回最长的+1
      */
    def dfs(mat: Matrix, memo: Matrix, i: Int, j: Int): Int = if (memo(i)(j) > 0) memo(i)(j) else {
      val (m, n) = (mat.length, mat(0).length) //高和宽,对应i和j
      val nextLengths = List((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)) //四个方向
        .filter(_ match { case (x, y) => x >= 0 && x < m && y >= 0 && y < n && mat(x)(y) > mat(i)(j) }) //过滤递增的点
        .map(p => dfs(mat, memo, p._1, p._2)) //递归计算每个点的长度
      memo(i)(j) = if(nextLengths.isEmpty) 1 else nextLengths.max + 1 //加一是当前点引入的长度
      memo(i)(j)
    }

    if (matrix.isEmpty || matrix(0).isEmpty) {
      0
    } else {
      val (m, n) = (matrix.length, matrix(0).length)
      val memo = Array.ofDim[Int](m, n) //备忘录
      (for (i <- 0 until m; j <- 0 until n) yield dfs(matrix, memo, i, j)).max
    }
  }
}
