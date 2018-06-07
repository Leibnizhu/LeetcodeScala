package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
  *
  * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
  * 说明：本题中，我们将空字符串定义为有效的回文串。
  */
object JudgePalindrome {
  def isPalindrome(s: String): Boolean = {
    if (s == null) {
      false
    } else if (s.trim.length == 0) {
      true
    } else {
      /**
        * 去除非字母数字的字符之后,两边游标收缩判断即可
        */
      val clean = s.toLowerCase.replaceAll("[^0-9a-z]", "")
      val len = clean.length
      for(i<- 0 until len /2)
        if(clean.charAt(i) != clean.charAt(len - 1 -i))
          return false
      true
    }
  }
}
