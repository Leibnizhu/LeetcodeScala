package leetcode.hard.arraystring

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/124/
  *
  * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
  */
object SpiralMatrix {
  /**
    * 不考虑复杂度,比较优美的,可以每次取第一行(取完后删掉),然后将矩阵逆时针旋转90度,如此循环
    * 但是旋转时间复杂度是O(m*n),要循环大于m+n次,由此时间复杂度O((m*n)*(m+n))基本是三次幂,相当差
    * 所以还是简单地模拟,规定好x,y的最大最小值去遍历,时间复杂度是O(m*n)
    */
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    if (matrix.isEmpty)
      return List()
    if (matrix.length == 1)
      matrix(0).toList
    else {
      //x对应列(宽度方向),y对应行(高度方向)
      var minX = 0
      var maxX = matrix(0).length - 1
      var minY = 0
      var maxY = matrix.length - 1
      val result = new ListBuffer[Int]()
      while (minX <= maxX && minY <= maxY) {
        for (i <- minX to maxX) result += matrix(minY)(i) //最上面一行
        minY += 1 //下一次上面要往下缩一行
        if(minY > maxY) return result.toList
        for (j <- minY to maxY) result += matrix(j)(maxX) //最右边一列
        maxX -= 1 //下一次右边要往左缩一列
        if(minX > maxX) return result.toList
        for (i <- maxX to minX by -1) result += matrix(maxY)(i) //最下面一行
        maxY -= 1 //下一次下面要往上缩一行
        if(minY > maxY) return result.toList
        for (j <- maxY to minY by -1) result += matrix(j)(minX) //最左边一列
        minX += 1 //下一次左边要往右缩一列
      }
      result.toList
    }
  }
}
