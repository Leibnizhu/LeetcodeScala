package leetcode.primary.string

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/
  *
  * 实现 strStr() 函数。
  * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
  * 说明:
  * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
  * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
  */
object IndexOf {

  /**
    * 既然是字符串匹配,肯定不要用暴力法啦,我们来试下KMP
    */
  def strStr(haystack: String, needle: String): Int = {
    if (needle.length == 0) 0 else kmp(haystack, needle)
  }

  private def makeNextArray(target: String, tl: Int, next: Array[Int]): Unit = {
    var maxLen = 0
    for(i <- 1 until tl){
      while(maxLen > 0 && target.charAt(maxLen) != target.charAt(i))//前缀后缀匹配失败,回退
        maxLen = next(maxLen - 1)
      if(target.charAt(maxLen) == target.charAt(i))
        maxLen += 1
      next(i) = maxLen
    }
  }

  private def kmp(src: String, target: String): Int = {
    val sl = src.length
    val tl = target.length
    val next = new Array[Int](tl)
    makeNextArray(target, tl, next)
    var count = 0 // target匹配成功的游标,匹配失败时回退
    for (i <- 0 until sl) { //src匹配的游标,不回退
      //target匹配一般出错时,target的游标利用next数组回退
      while (count > 0 && target.charAt(count) != src.charAt(i))
        count = next(count - 1)
      if (target.charAt(count) == src.charAt(i)) //对target逐个匹配
        count += 1
      if (count == tl) //匹配完成
        return i - tl + 1 //返回target的第一个字符位置
    }
    -1
  }
}
