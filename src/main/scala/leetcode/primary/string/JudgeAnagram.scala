package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
  *
  * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
  * 说明: 你可以假设字符串只包含小写字母。
  * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
  */
object JudgeAnagram {
  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) {
      false
    } else {
      /**
        * 与找字符串第一个唯一字符类似,我们用26长度的数组替代哈希表
        */
      val counter = new Array[Int](26)
      //遍历s所有字符, 在counter中对应加一,t的对应字符减一
      for (i <- 0 until s.length) {
        counter(s.charAt(i) - 'a') += 1
        counter(t.charAt(i) - 'a') -= 1
      }
      //如果counter全为1则为字母异位词
      (true/:counter)(_ && _ == 0)
    }
  }
}
