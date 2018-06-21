package leetcode.medium.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/114/
  *
  * 给定一个Excel表格中的列名称，返回其相应的列序号。
  * 例如，
  * A -> 1
  * B -> 2
  * C -> 3
  * ...
  * Z -> 26
  * AA -> 27
  * AB -> 28
  * ...
  */
object ExcelColumnNumber {
  /**
    * 其实就是26进制和10进制的转换
    * 转换前将字符串转换成数字数组就行
    */
  def titleToNumber(s: String): Int = {
    (0 /: s.toCharArray.map(_ - 'A' + 1)) (_ * 26 + _)
  }
}
