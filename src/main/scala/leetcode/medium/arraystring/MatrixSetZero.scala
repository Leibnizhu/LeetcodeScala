package leetcode.medium.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/76/
  *
  * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
  * 进阶:
  * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
  * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
  * 你能想出一个常数空间的解决方案吗？
  */
object MatrixSetZero {
  /**
    * m行n列,要常数空间,只能考虑用第0行/列来记录对应的行和列是否有0值
    * 而第0行和第0列是否0值,需要用额外的两个布尔值记录下来
    * 所以要先走完第0行和第0列,记录下来是否有0
    * 然后遍历1+行和1+列,把对应行和列是否有0记录在第0行/列
    * 接着根据第0行/列把1+行/列置0
    * 最后根据额外空间的两个布尔型参数把第0行/列置0/不处理
    */
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val m = matrix.length //行数
    val n = matrix(0).length //列数
    var zeroRowHasZero = false //第0行是否有0
    var zeroColumnHasZero = false //第0列是否有0
    //1.走完第0行和第0列,记录下来是否有0
    for (i <- 0 until m) if (matrix(i)(0) == 0) zeroColumnHasZero = true
    for (j <- 0 until n) if (matrix(0)(j) == 0) zeroRowHasZero = true
    //2.遍历1+行和1+列,把对应行和列是否有0记录在第0行/列
    for {
      i <- 1 until m
      j <- 1 until n
    } yield if (matrix(i)(j) == 0) {
      matrix(0)(j) = 0
      matrix(i)(0) = 0
    }
    //3.根据第0行/列把1+行/列置0
    for {
      i <- 1 until m
      j <- 1 until n
    } yield if (matrix(0)(j) == 0 || matrix(i)(0) == 0)
      matrix(i)(j) = 0
    //4.根据zeroRowHasZero和zeroColumnHasZero把第0行/列置0/不处理
    if (zeroColumnHasZero)
      for (i <- 0 until m)
        matrix(i)(0) = 0
    if (zeroRowHasZero)
      for (j <- 0 until n)
        matrix(0)(j) = 0
  }
}
