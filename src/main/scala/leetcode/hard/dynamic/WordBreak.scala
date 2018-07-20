package leetcode.hard.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/157/
  *
  * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
  * 说明：
  *  - 拆分时可以重复使用字典中的单词。
  *  - 你可以假设字典中没有重复的单词。
  */
object WordBreak {
  /**
    * 动态规划,设f(i)为s[0,i]子串,是否可以用wordDict的单词拼成
    * 不难有:
    * f(i) = 对 j ∈ [0, i),至少存在一个j使得 f[j] && s[j,i] ∈ wordDict
    */
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val f = Array.fill(s.length + 1)(false) //多留一位初始位(子串长度为0)
    f(0) = true //子串长度为0时要true,拆分空串+全串的时候,也可以满足条件,使f有意义
    lazy val dictSet = wordDict.toSet //因为要用到contains,为了提高效率,转成Set
    for (i <- 1 to s.length) //遍历计算f,期间遍历s[i-1,i]到s[0,i]的拆分组合,为了提高效率提前退出,可以用view
      f(i) = (0 until i).view.exists(j => f(j) && dictSet.contains(s.substring(j, i)))
    f.last
  }
}
