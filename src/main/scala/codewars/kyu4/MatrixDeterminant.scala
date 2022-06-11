package codewars.kyu4

/**
  * 2022-06-11
  * {@see <a href='https://www.codewars.com/kata/52a382ee44408cea2500074c/train/scala'/> }
  */
object MatrixDeterminant {
  def determinant(matrix: Array[Array[Int]]): Int = {
    def getLineTran(p: Array[Array[Double]], n: Int): Double = if (n == 1) p(0)(0) else {
      var (exchange, isZero) = (1, false) //交换行数和行列式最右元素是否为0
      for (i <- 0 until n) {
        if (p(i)(n - 1) != 0) { // 若第 i 行最右边的元素不为零
          isZero = true
          if (i != (n - 1)) { // 若第 i 行不是行列式的最后一行
            for (j <- 0 until n) { // 以此交换第 i 行与第 n-1 行各元素
              val temp = p(i)(j)
              p(i)(j) = p(n - 1)(j);
              p(n - 1)(j) = temp;
            }
            exchange *= -1;
          }
        }
      }
      if (!isZero) 0 else {
        for (i <- 0 until n - 1) { // 用第 n-1 行的各元素，将第 i 行最右边元素 p(i)(n-1] 变换为 0
          if (p(i)(n - 1) != 0) {
            // 计算第  n-1 行将第 i 行最右边元素 p(i)(n-1] 变换为 0的比例
            val proportion = p(i)(n - 1) / p(n - 1)(n - 1); //FIXME 精度问题
            for (j <- 0 until n) {
              p(i)(j) += p(n - 1)(j) * (-proportion);
            }
          }
        }
        exchange * p(n - 1)(n - 1) * getLineTran(p, n - 1)
      }
    }

    val d = getLineTran(matrix.map(_.map(_.toDouble)), matrix.length)
    println(d)
    Math.round(d).toInt
  }
}
