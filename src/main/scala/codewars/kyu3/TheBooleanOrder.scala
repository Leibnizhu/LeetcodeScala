package codewars.kyu3

/**
  * 2022-06-25
  * {@see <a href='https://www.codewars.com/kata/59eb1e4a0863c7ff7e000008/train/scala'/> }
  */
object TheBooleanOrder {
  /**
    * 一眼DP
    * 令 dp(i)(j) = 字符串str从i开始长度j的子串(str.substring(i,i+j))，计算的元祖 (结果为true的可能数量，结果为false的可能数量)
    * 那么 dp(x)(1) = (str(x)=='t':1:0, str(x)=='f':1:0)
    * 计算 dp(i)(j) 的时候情况多一些，需要遍历 i -> i+j -1 之间的operators符号，分类处理。
    * 迭代算dp的时候，需要看当前字符串（长度l）的l-1种切分情况，加起来：
    * dp(i)(j) = sum( combine(dp(i)(x-i+1), dp(x+1)(j-x), operators(x)) ), x=i until j
    * 其中combine是根据 operators里面x对应的符号，算合并起来的可能数
    * 比如:
    * combine((t1,f1),(t2,f2), '&')=(t1 * t2, t1 * f2 + t2 * f1 + f1 * f2) 两边都是true结果才是true，其余情况false
    * combine((t1,f1),(t2,f2), '|')=(t1 * f2 + t2 * f1 + t1 * t2, f1 * f2) 两边都是false结果才是false，其余情况true
    * combine((t1,f1),(t2,f2), '^')=(t1 * f2 + t2 * f1, t1 * t2 + f1 * f2) 两边都是不同结果才是true，两边一样的情况false
    * 最后结果就是 dp(0)(str长度)._1
    */
  def solve(operands: String, operators: String): Long = {
    def combine(t1: Long, f1: Long, t2: Long, f2: Long, op: Char): (Long, Long) = op match {
      case '&' => (t1 * t2, t1 * f2 + t2 * f1 + f1 * f2)
      case '|' => (t1 * f2 + t2 * f1 + t1 * t2, f1 * f2)
      case '^' => (t1 * f2 + t2 * f1, t1 * t2 + f1 * f2)
    }

    val N = operands.length
    val dp = Array.fill(N, N + 1)((0L, 0L))
    for (i <- 0 until N) dp(i)(1) = (if (operands(i) == 't') 1L else 0L, if (operands(i) == 'f') 1L else 0L)
    for (len <- 2 to N) {
      for (start <- 0 to N - len) {
        val end = start + len - 1
        dp(start)(len) = (start until end).map(mid => {
          val left = dp(start)(mid - start + 1) //[start,mid]子串
          val right = dp(mid + 1)(end - mid) //(mid,end]子串
          combine(left._1, left._2, right._1, right._2, operators(mid))
        }).foldLeft((0L, 0L))((s, c) => (s._1 + c._1, s._2 + c._2))
      }
    }
    dp(0)(N)._1
  }
}
