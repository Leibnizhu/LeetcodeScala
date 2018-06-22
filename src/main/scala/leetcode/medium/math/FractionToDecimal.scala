package leetcode.medium.math

import scala.collection.mutable

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/118/
  *
  * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
  * 如果小数部分为循环小数，则将循环的部分括在括号内。
  */
object FractionToDecimal {
  /**
    * 关键点:
    * 1. 0的处理
    * 2. 正负号处理
    * 3. 循环小数,当余数再次出现的时候,可以判定出现循环了,因此可以用一个Set记下来
    * 但是由于我们还要根据循环的哪几位插入括号,所以用Map记录 余数->小数位数
    */
  def fractionToDecimal(numerator: Int, denominator: Int): String = {
    if (numerator == 0)
      "0"
    else {
      val buf = new StringBuilder
      if (numerator < 0 ^ denominator < 0) buf.append('-') //分子分母符号相反则加负号
      val m = Math.abs(numerator.toLong) //分子,要转long防止Int.MinValue溢出
      val n = Math.abs(denominator.toLong) //分母,要转long防止Int.MinValue溢出
      buf.append(m / n) //整数部分
      if (m % n == 0)
        buf.toString()
      else {
        buf.append('.')
        val remainderMap = new mutable.HashMap[Long, Int]() // 余数->对应小数在字符串下标
        var remainder = m % n //当前余数
        while (remainder != 0) {
          if (remainderMap.contains(remainder)) //余数重复出现,可以加上括号终结了
            return buf.insert(remainderMap(remainder), '(').append(')').toString()
          remainderMap.put(remainder, buf.length)
          remainder *= 10 //移位,继续下一步除法操作
          buf.append(remainder / n)
          remainder %= n
        }
        buf.toString()
      }
    }
  }
}