package leetcode.medium.math

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/117/
  *
  * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
  * 返回被除数 dividend 除以除数 divisor 得到的商。
  *
  * 说明:
  *  - 被除数和除数均为 32 位有符号整数。
  *  - 除数不为 0。
  *  - 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
  */
object DivideTwo {
  /**
    * 不能用乘除mod,那么只能位移和加减法了
    * 显然最基础的版本是从0开始不断地加divisor,直到(绝对值)第一次大于dividend
    * 但这样显然很慢, 可以通过每次尝试将被除数增倍的方法来缩短时间
    * 剩余的被除数,小于倍增的除数的时候,就可以将除数恢复为原来的大小,重新反复增倍
    * 相当于对结果的二进制从高位到低位求
    * 大概可以从 O(dividend/divisor) 降到 O(log(dividend/divisor))
    */
  def divide(dividend: Int, divisor: Int): Int = {
    if (dividend == 0)
      0
    else if (divisor == 0) //溢出情况1
      Int.MaxValue
    else if (dividend == Int.MinValue) {//溢出情况2 下面求绝对值的时候dividend会溢出
      if (divisor == -1) // 特殊情况
        Int.MaxValue
      else if (divisor < 0) //除数也负数,那么商为正,提前扣掉一次除数(对应商+1),防止溢出
        1 + divide(dividend - divisor, divisor)
      else //除数为正,商为负, 需要提前加上一次除数(对应商-1),防止溢出
        -1 + divide(dividend + divisor, divisor)
    } else if (divisor == Int.MinValue){ //溢出情况3,下面divisor求绝对值会溢出
      if(dividend == divisor) 1 else 0 //只有minvalue相除才等于1,其他情况都小于1
    } else{
      //对绝对值求除法,最后再调整结果的符号
      var a = if (dividend > 0) dividend else -dividend //被除数,不断减去除数
      val b = if (divisor > 0) divisor else -divisor //除数,每一轮迭代的时候倍增,加速
      var result = 0 //在迭代的过程中保存结果
      while (a >= b) { //被除数减掉的结果还大于除数,就可以继续减,然后result增加
        var s = b //用于加速除数
        var i = 0 //第i轮加速
        while (a >= s) { //被除数还可以被加速的除数所减
          a -= s
          result += 1 << i //第i轮加速时, 减去的除数为power(2,i)次
          if (s <= 1073741823) { //不能用除法,这里写死Int.MaxValue/2,为了防止溢出
            i += 1 //轮数+1
            s <<= 1 //除数加倍
          }
        }
      }
      //异或之后看最高位,如果符号不同,那么异或为1,商为负数,异或为0是符号相同,商为正数
      if (((dividend ^ divisor) >> 31) == 0) result else -result
    }
  }
}
