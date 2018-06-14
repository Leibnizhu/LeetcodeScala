package leetcode.medium.backtracking

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/92/
  *
  * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
  */
object GenerateParenthesis {
  /**
    * 必须满足当左括号数量小于n,则可以增加左括号, 当右括号小于左括号的数量,则可以增加右括号
    * 从递归的角度来看,n与n-1相比多了一对括号
    * 这对括号插入到n-1的结果里,将n-1的结果拆分成两部分,一部分在括号内一部分在括号外
    * 为了避免重复,将新增括号的左括号作为第一个括号,且n-1拆成的两部分分别有效
    * 亦即f(n) = "(" + f(i) + ")" + f(n-1-i)
    * 为了提速,要用备忘录
    */
  def generateParenthesis(n: Int): List[String] = {
    if (n <= 0) {
      List()
    } else {
      val memo = Array.fill(n + 1)(new ListBuffer[String])
      memo(0) += ""
      memo(1) += "()"
      for {
        i <- 2 to n //要计算的n,从小到大,插入到备忘录
        j <- 0 until i //遍历i下面多种分配方案
        inner <- memo(j) //每种分配方案的新括号内字符串
        outer <- memo(i - 1 - j) //每种分配方案的新括号外字符串
      } yield memo(i) += "(" + inner + ")" + outer //拼接,放入备忘录
      memo.last.toList
    }
  }
}
