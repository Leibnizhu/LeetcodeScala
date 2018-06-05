package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/37/
  *
  * 实现 atoi，将字符串转为整数。
  * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。
  * 如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
  * 如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
  * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
  * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
  * 若函数不能执行有效的转换，返回 0。
  * 说明：假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
  * 如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
  */
object ParseInt {
  def myAtoi(str: String): Int = {
    val chars = str.toCharArray
    val len = chars.length
    if (len == 0) {
      //空字符串,返回0
      0
    } else {
      var i = 0
      //跳过字符串前面的空格
      while (i < len && chars(i) == ' ') i += 1
      if(i >= len) return 0
      //符号判断
      val neg = chars(i) == '-'
      if (chars(i) == '+' || chars(i) == '-') i+=1
      //数字解析
      if ( i < len && chars(i) >= '0' && chars(i) <= '9') {
        var abs = 0
        val maxHead = Integer.MAX_VALUE/10
        val maxLast = Integer.MAX_VALUE%10
        val minHead = Math.abs(Integer.MIN_VALUE/10)
        val minLast = Math.abs(Integer.MIN_VALUE%10)
        while( i < len && chars(i) >= '0' && chars(i) <= '9'){
          val cur = chars(i) - '0'
          //处理最大值
          if(!neg && (abs > maxHead || (abs == maxHead && cur >= maxLast)))
            return Integer.MAX_VALUE
          //处理最小值
          if(neg && (abs > minHead || (abs == minHead && cur >= minLast)))
            return Integer.MIN_VALUE
          //正常情况
          abs =  abs * 10 + cur
          i += 1
        }
        if(neg) -abs else abs
      } else {
        //非法字符,返回0
        0
      }
    }
  }
}
