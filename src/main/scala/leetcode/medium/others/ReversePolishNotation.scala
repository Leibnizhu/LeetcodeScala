package leetcode.medium.others

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/120/
  *
  * 根据逆波兰表示法，求表达式的值。
  * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
  * 说明：
  *  - 整数除法只保留整数部分。
  *  - 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
  */
object ReversePolishNotation {
  /**
    * 根据逆波兰表示法的定义,可以一次读取tokens, 并维护一个栈
    * 读到数则放进去,读到运算符号则提取两个数出来进行计算再返回去栈
    * 直到处理完所有,最后一次计算结果会放进栈,读出来返回即可
    */
  def evalRPN(tokens: Array[String]): Int = {
    val stack = new ListBuffer[Int]()
    for (token <- tokens) {
      if (token == "+" || token == "-" || token == "*" || token == "/") {
        val a = stack.remove(stack.size - 1)
        val b = stack.remove(stack.size - 1)
        stack += (token match {
          case "+" => a + b
          case "-" => b - a
          case "*" => a * b
          case "/" => b / a
        })
      } else
        stack += Integer.parseInt(token)
    }
    stack.last
  }
}
