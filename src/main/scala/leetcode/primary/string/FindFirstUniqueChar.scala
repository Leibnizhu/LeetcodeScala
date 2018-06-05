package leetcode.primary.string

/**
  * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
  * 注意事项：您可以假定该字符串只包含小写字母。
  */
object FindFirstUniqueChar {
  def firstUniqChar(s: String): Int = {
    /**
      * 字母自身构成索引,不需要用到Hash,直接用字符-'a'即可
      */
    val counter = new Array[Int](26)
    val chars = s.toCharArray
    //遍历所有字符, 在counter中对应加一
    for (i <- 0 until chars.length)
      counter(chars(i) - 'a') += 1
    for (i <- 0 until chars.length)
      if (counter(chars(i) - 'a') == 1)
        return i
    -1
  }
}
