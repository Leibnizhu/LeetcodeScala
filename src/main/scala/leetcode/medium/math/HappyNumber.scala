package leetcode.medium.math

import scala.collection.mutable

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/112/
  *
  * 编写一个算法来判断一个数是不是“快乐数”。
  * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
  */
object HappyNumber {
  /**
    * 按题目要求去循环即可,再用一个set区判断是否已经出现过
    */
  def isHappy(n: Int): Boolean = {
    val used = mutable.HashSet[Int]()
    var num = n
    while (!used.contains(num)){
      used += num
      var sum = 0
      while(num > 0){
        val digit = num % 10
        sum += digit * digit
        num /= 10
      }
      num = sum
      if(num == 1)
        return true
    }
    false
  }
}
