package leetcode.primary.others

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/67/
  *
  * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
  * 在杨辉三角中，每个数是它左上方和右上方的数的和。
  */
object PascalTriangle {
  def generate(numRows: Int): List[List[Int]] = {
    val result = new ListBuffer[ListBuffer[Int]]()
    for (i <- 0 until numRows) { //每一行
      val curRow = new ListBuffer[Int]()
      if (i == 0) {
        curRow += 1
      } else {
        val prevRow = result(i - 1)
        for (j <- 0 to i) //行内每一个元素
        //Pascal三角的特性
          curRow += (if (j == 0) 1 else if(j == i) 1 else prevRow(j - 1) + prevRow(j))
      }
      result += curRow
    }
    result.map(_.toList).toList
  }
}
