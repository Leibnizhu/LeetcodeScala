package leetcode.primary.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/60/
  *
  * 写一个程序，输出从 1 到 n 数字的字符串表示。
  * 1. 如果 n 是3的倍数，输出“Fizz”；
  * 2. 如果 n 是5的倍数，输出“Buzz”；
  * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
  */
object FizzBuzz {
  def fizzBuzz(n: Int): List[String] = {
    (1 to n).map {
      case x: Int if x % 3 == 0 && x % 5 == 0 => "FizzBuzz"
      case x: Int if x % 3 == 0 => "Fizz"
      case x: Int if x % 5 == 0 => "Buzz"
      case x: Int => String.valueOf(x)
    }.toList
  }
}
