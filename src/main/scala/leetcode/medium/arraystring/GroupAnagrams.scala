package leetcode.medium.arraystring

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/77/
  *
  * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
  * 说明：
  *  - 所有输入均为小写字母。
  *  - 不考虑答案输出的顺序。
  */
object GroupAnagrams {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    val groups = new mutable.HashMap[String, ListBuffer[String]]()
    for(str <- strs){
      val sorted = String.valueOf(str.toCharArray.sorted).intern()
      groups.getOrElseUpdate(sorted,ListBuffer()).+=(str)
    }
    groups.values.map(_.toList).toList
  }
}
