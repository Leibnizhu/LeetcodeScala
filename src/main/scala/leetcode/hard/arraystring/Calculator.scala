package leetcode.hard.arraystring

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/131/
  *
  * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
  * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
  * 说明：
  *  - 你可以假设所给定的表达式都是有效的。
  *  - 请不要使用内置的库函数 eval。
  */
object Calculator {
  /**
    * 没有括号,相对简单一点.
    * 没有括号的话只有两种计算优先级,加法减法和乘法除法,优先计算乘法除法,
    * 因此可以先把乘法除法计算完之后,再求和(减法等于加上相反数)
    * 用一个栈记录所有需要相加的数,+x直接放x,-x放-x,遇到*x /x就出栈与x计算后重新入栈,
    * 遍历完之后,所有出栈求和并返回即可
    * 此外要处理空格以及多位数字
    */
  def calculate(s: String): Int = {
    val stack = new ListBuffer[Int]()
    var op = '+' //默认初始的运算相当于0+
    var curNum = 0 //当前处理的数字
    for (i <- 0 until s.length) {
      val c = s.charAt(i)
      if (c >= '0' && c <= '9') //继续有新数字
        curNum = curNum * 10 + c - '0'
      if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length - 1) { //遇到符号
        //根据前面一个符号进行处理
        op match {
          case '+' => stack += curNum
          case '-' => stack += -curNum
          case '*' => stack.update(stack.length - 1, stack.last * curNum)
          case '/' => stack.update(stack.length - 1, stack.last / curNum)
        }
        op = c //更新符号
        curNum = 0 //当前处理的数字归零
      }
    }
    stack.sum //全部数字出栈求和
  }
}
