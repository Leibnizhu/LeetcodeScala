package codewars.kyu4

/**
  * 2022-06-10
  * {@see <a href='https://www.codewars.com/kata/593ff8b39e1cc4bae9000070/train/scala'/> }
  */
object LongestCommonSubsequencePerformanceVersion {
  /**
    * 经典DP
    * dp(i)(j) 为 a(0->i) 与 b(0->j) 子串的最长公共子串长度
    * 显然对 i=0, j=0->b.length-1 ，a的子串为a(0)，显然 dp(0)(j) = a(0) == b(j) ? dp(0)(j-1)+1 : dp(0)(j-1)
    * 同理对，i=0->a.length-1,j=0, dp(i)(0) = a(i) == b(0) ? dp(i-1)(0)+1 : dp(i-1)(0)
    * 剩下的显然： 若 a(i) == b(j) ，当前字符相同可以比对角线多一个字符，即 dp(i)(j) = dp(i-1)(j-1) + 1 ;
    * 否则当前字符不同，取决于两边原来最长的子串，即 dp(i)(j) = max(dp(i-1)(j), dp(i)(j-1))
    * 这样需要一个 a.length * b.length 的二维数组
    *
    * 然后从尾反推子串
    */
  def lcs(a: String, b: String): String = {
    if (a.isEmpty || b.isEmpty) return ""
    val dp = Array.ofDim[Int](a.length + 1, b.length + 1) //多套一圈，省一些越界判断
    for {
      i <- 1 to a.length
      j <- 1 to b.length
    } yield if (a(i - 1) == b(j - 1))
      dp(i)(j) = dp(i - 1)(j - 1) + 1
    else
      dp(i)(j) = math.max(dp(i - 1)(j), dp(i)(j - 1))
    var (i, j, curLen) = (a.length, b.length, dp.last.last)
    var result = List[Char]()
    while (curLen > 0) {
      if (a(i - 1) == b(j - 1)) { //相等时走对角线
        result ::= a(i - 1)
        i -= 1
        j -= 1
        curLen -= 1
      } else { //不相等走较大者
        if (dp(i - 1)(j) > dp(i)(j - 1)) {
          i -= 1
        } else {
          j -= 1
        }
      }
    }
    result.mkString
  }
}
