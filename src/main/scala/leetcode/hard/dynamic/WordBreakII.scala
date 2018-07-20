package leetcode.hard.dynamic

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/158/
  *
  * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
  * 说明：
  *  - 分隔时可以重复使用字典中的单词。
  *  - 你可以假设字典中没有重复的单词。
  */
object WordBreakII {
  /**
    * 根据f.last的拆分位置List,DFS查找(每条路径不一样,BFS的话要知道任务对应的前序路径,这样任务队列就比较乱了)
    */
  def calculateResult(s: String, f: Array[(Boolean, List[Int])]): List[String] = {
    def dfs(start: Int, curPath: List[Int], curRes: List[String]): List[String] =
      if (start == 0) { //到尾部了
        val buf = new StringBuilder(s)
        var count = 0 //记录相比curPath的下标,插入位置应该后移多少
        curPath.tail.foreach(i => { //第一个肯定是0,要忽略掉
          buf.insert(i + count, " ")
          count += 1 //每次插入之后,下次要插入的位置需要后移,
        })
        curRes :+ buf.toString
      } else {
        var tmpRes = curRes
        f(start)._2.foreach(p => tmpRes = dfs(p, p :: curPath, tmpRes))
        tmpRes
      }

    dfs(f.length - 1, List(), List())
  }

  /**
    * 与WordBreak类似, 但这一题需要把解记录下来
    */
  def wordBreak(s: String, wordDict: List[String]): List[String] = {
    val f = new Array[(Boolean, List[Int])](s.length + 1) //多留一位初始位(子串长度为0), (是否可拆分, 可用的拆分的位置List)
    f(0) = (true, null) //子串长度为0时要true,拆分空串+全串的时候,也可以满足条件,使f有意义
    lazy val dictSet = wordDict.toSet //因为要用到contains,为了提高效率,转成Set
    for (i <- 1 to s.length) { //遍历计算f
      val usableSplit = (0 until i).filter(j => f(j)._1 && dictSet.contains(s.substring(j, i))) //遍历s[i-1,i]到s[0,i]的拆分组合
      f(i) = (usableSplit.nonEmpty, usableSplit.toList)
    }
    calculateResult(s, f)
  }
}
