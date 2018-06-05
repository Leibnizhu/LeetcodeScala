package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
  *
  * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
  * 1.     1
  * 2.     11
  * 3.     21
  * 4.     1211
  * 5.     111221
  * 1 被读作  "one 1"  ("一个一") , 即 11。
  * 11 被读作 "two 1s" ("两个一"）, 即 21。
  * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
  *
  * 给定一个正整数 n ，输出报数序列的第 n 项。
  * 注意：整数顺序将表示为一个字符串。
  */
object CountAndSay {
  def countAndSay(n: Int): String = {
    if (n == 1) {
      "1"
    } else {
      val lastStr = countAndSay(n - 1)
      var res = "" //保存最终结果
      var curChar: Char = 0 //当前重复的数字
      var curCount = 0 //当前重复数字的计数
      for (i <- 0 until lastStr.length) {
        if (curChar != lastStr.charAt(i)) {
          if (i > 0) res = res + curCount + curChar
          curChar = lastStr.charAt(i)
          curCount = 1
        } else {
          curCount += 1
        }
      }
      if (curChar == 0) res + 1 + lastStr.last else res + curCount + curChar
    }
  }
}
