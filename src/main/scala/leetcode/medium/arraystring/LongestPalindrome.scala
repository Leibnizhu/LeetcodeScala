package leetcode.medium.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/79/
  *
  * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
  */
object LongestPalindrome {
  /**
    * 动态规划，时间复杂度O(n^2),空间复杂度O(n^2)
    * f(i)(j)表示下标从i到j的字串是否回文
    * f(i)(j) = true ,如果i==j
    * f(i)(j) = s[i]==s[j]，如果j=i+1
    * f(i)(j) =  s[i]==s[j] && f(i+1)(j-1)，如果j>i+1
    * 用二位数组存储f
    */
  def longestPalindrome(s: String): String = {
    val len = s.length
    val f = Array.ofDim[Boolean](len, len)
    var maxLen = 0 //维护最大回文子串长度
    var start = 0 //最大回文子串的开始位置
    //为了保证可计算，应该从长度1的字串开始算，逐渐增加，到最后才跑整个串
    for (j <- 0 until len) {
      //字串结束下标，从0开始
      f(j)(j) = true //基本情况
      for (i <- 0 until j) { //字串开始下标
        f(i)(j) = s.charAt(i) == s.charAt(j) && (j == i + 1 || f(i + 1)(j - 1)) //综合方法注释的两个条件，判断当前子串是否回文
        if (f(i)(j) && j - 1 + 1 > maxLen) {
          //当前子串为回文的话，判断maxLen是否要更新
          maxLen = j - 1 + 1
          start = i
        }
      }
    }
    s.substring(start, start + maxLen)
  }
}
