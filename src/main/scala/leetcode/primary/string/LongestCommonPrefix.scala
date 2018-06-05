package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/40/
  *
  * 编写一个函数来查找字符串数组中的最长公共前缀。
  * 如果不存在公共前缀，返回空字符串 ""。
  * 说明: 所有输入只包含小写字母 a-z 。
  */
object LongestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.length == 0) {
      ""
    } else {
      /**
        * 暴力逐列对比就行
        */
      for (i <- 0 until strs(0).length)
        for (j <- 1 until strs.length)
          if (i == strs(j).length || strs(j).charAt(i) != strs(0).charAt(i))//到某个字符串的结尾,或者有字符串的字符不相同,就退出
            return strs(0).substring(0, i)
      strs(0)
    }
  }
}
