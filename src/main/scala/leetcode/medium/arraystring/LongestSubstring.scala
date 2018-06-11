package leetcode.medium.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/78/
  *
  * 给定一个字符串，找出不含有重复字符的最长子串的长度。
  */
object LongestSubstring {
  /**
    * 遍历字符串，把字符出现的位置记录在数组（长度等于ascii总和，相当于做了索引）
    * 当当前字符在pos数组中有效时，就是说发生重复了，则将start改成pos对应的下标+1
    * 同时维护maxLen为最大值
    * 最后退出的时候也要进行处理，保证最长串出现在后缀也能被检查到
    */
  def lengthOfLongestSubstring(s: String): Int = {
    val pos = Array.fill(255)(-1) //初始化为-1，因为0也是有效位置
    var maxLen = 0
    var start = 0 //当前字串的开始位置
    for(i <- 0 until s.length){
      val cur:Int = s.charAt(i)
      if(pos(cur) >= start) { // 当前字符在start之后出现过，发生重复了
        maxLen = Math.max(i - start, maxLen) //当前重复的字符不算进长度里面
        start = pos(cur) + 1
      }
      pos(cur) = i //维护pos数组
    }
    Math.max(maxLen, s.length - start)
  }
}
