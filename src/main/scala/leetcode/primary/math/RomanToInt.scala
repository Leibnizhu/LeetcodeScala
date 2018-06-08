package leetcode.primary.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/63/
  * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
  *
  * 字符          数值
  * I             1
  * V             5
  * X             10
  * L             50
  * C             100
  * D             500
  * M             1000
  * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
  *
  * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
  *
  * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
  * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
  * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
  * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
  */
object RomanToInt {
  /**
    * 主要问题在于IV 这种要后面减去前面的数的
    * 因此比较前面的数字,如果发现后面的数比前面的大,要减去
    */
  def romanToInt(s: String): Int = {
    var result = 0
    val nums = s.toCharArray.map(singleRomanMap)
    for (i <- 0 until s.length) {
      val cur = nums(i) //当前
      if (i > 0 && cur > nums(i - 1))
        result += (cur - 2 * nums(i - 1)) //减两次,第一次是之前多加的一次,第二次是正确要减的一次
      else
        result += cur
    }
    result
  }

  private def singleRomanMap: Char => Int = {
    case 'I' => 1
    case 'V' => 5
    case 'X' => 10
    case 'L' => 50
    case 'C' => 100
    case 'D' => 500
    case 'M' => 1000
    case _ => 0
  }
}
