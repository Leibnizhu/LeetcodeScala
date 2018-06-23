package leetcode.medium.others

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/119/
  *
  * 不使用运算符 + 和-，计算两整数a 、b之和。
  */
object SumByBit {
  /**
    * 不使用+和-,那就是位运算咯
    * 不考虑进位的话,0+0=0,1+1=0+1=1, 1+1=(1)0,就是按位异或
    * 从上面四种情况可见,进位为按位与,进位结果需要左移一位继续相加.
    * 那么其实是可以递归的,每次计算后,将按位异或的结果和按位与左移一位继续相加
    */
  def getSum(a: Int, b: Int): Int = {
    val sum = a ^ b
    val carry = a & b
    if (carry == 0) sum else getSum(sum, carry << 1)
  }
}
