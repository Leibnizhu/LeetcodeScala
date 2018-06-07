package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/
  *
  * 请编写一个函数，其功能是将输入的字符串反转过来。
  */
object ReverseString {

  def reverseString(s: String): String = {
    /**
      * 用scala自带的String.reverse会报超时,直接用遍历写一个
      */
    if (s == null || s.length() == 0) {
      s
    } else {
      val chars = s.toCharArray
      val len = chars.length
      for (i <- 0 until len / 2) {
        chars(i) = s.charAt(len - 1 - i)
        chars(len - 1 - i) = s.charAt(i)
      }
      String.copyValueOf(chars)
    }
  }
}
