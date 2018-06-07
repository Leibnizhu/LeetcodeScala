package leetcode.primary.array

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
  *
  * 给定一个 n × n 的二维矩阵表示一个图像。
  * 将图像顺时针旋转 90 度。
  * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
  */
object RotateMatrix {
  def rotate(matrix: Array[Array[Int]]): Unit = {
    def swap(matrix: Array[Array[Int]])(i: Int, j: Int)(m: Int, n: Int): Unit = {
      val tmp = matrix(i)(j)
      matrix(i)(j) = matrix(m)(n)
      matrix(m)(n) = tmp
    }

    val n = matrix.length

    /**
      * 顺时针旋转90度,其实就是正对角线镜像再垂直线镜像
      * 1 2   =>  1 3  => 3 1
      * 3 4       2 4     4 2
      */
    //1.正对角线镜像
    for {
      i <- 0 until n
      j <- i until n
    } yield swap(matrix)(i,j)(j,i)
//    matrix.foreach(l => println(l.toList))
    //2. 垂直线镜像
    for{
      i <- 0 until n
      j <- 0 until n/2
    } yield swap(matrix)(i,j)(i, n-1-j)
//    matrix.foreach(l => println(l.toList))
  }
}
