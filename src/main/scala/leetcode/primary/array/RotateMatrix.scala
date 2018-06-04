package leetcode.primary.array

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
