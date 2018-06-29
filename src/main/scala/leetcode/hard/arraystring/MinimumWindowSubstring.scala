package leetcode.hard.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/133/
  *
  * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
  * 示例：
  * 输入: S = "ADOBECODEBANC", T = "ABC"
  * 输出: "BANC"
  * 说明：
  *  - 如果 S 中不存这样的子串，则返回空字符串 ""。
  *  - 如果 S 中存在这样的子串，我们保证它是唯一的答案。
  */
object MinimumWindowSubstring {
  val MAX_CHAR = 255

  /**
    * 用hash分别记录目标串和源串各个字符出现的次数.,先计算目标串的,然后再遍历源串的
    * 这里用数组替代hash,因为字符种类数量是固定的
    * 遍历源串的时候,统计频率之后,如果当前字符的出现次数小于或等于目标串的,那就是找到了一位匹配的
    * (大于的不管,因为这个字符已经满足了,不会再影响到匹配的情况,只要记录下频率即可)
    * 当目标串的字符都匹配上了(可以通过长度来判断),找到了匹配的子串, 此时子串可以从左边开始查找哪些字符去掉对匹配无影响的,可以去掉.
    * 然后就得到了一个当前最小的匹配串,同时记录下长度及其左右下标.
    * 然后可以继续按上面的逻辑查找下一个匹配的子串
    * 到最后根据我们记录的最小子串的左右下标拿出子串返回
    */
  def minWindow(s: String, t: String): String = {
    val tHash = new Array[Int](MAX_CHAR) //统计目标字符串各字符出现次数
    val sHash = new Array[Int](MAX_CHAR) //统计源字符串各字符出现次数
    for (c <- t.toCharArray) tHash(c) += 1
    var (l, r) = (-1, s.length) //匹配子串左右下标
    var (p,count) = (0,0) //(匹配子串的游标,当前匹配到目标串的字符个数)
    var minLen = s.length //维护最小子串长度
    for (i <- 0 until s.length) {
      val c = s.charAt(i)
      sHash(c) += 1 //统计频率
      if (sHash(c) <= tHash(c)) count += 1 //当前字符不超过目标串中出现的次数, 则找到一个匹配字符,超过的时候不+1避免影响下面一行判断
      if (count == t.length) { //找到t全部字符都匹配的子串了
        //把当前子串前面对目标字符串无用的去掉,即左边界右缩
        while (p < i && sHash(s.charAt(p)) > tHash(s.charAt(p))) {
          sHash(s.charAt(p)) -= 1 //计数减一,至少会等于tHash对应字符的,这样才能保证满足t的匹配
          p += 1
        }
        if (i - p < minLen) { //子串长度更新最小值及对应下标
          minLen = i - p
          l = p
          r = i
        }
        //查找下一个子串
        sHash(s.charAt(p)) -= 1 //当前字符对应的频率要减一了
        count -= 1 //当前匹配的将被去掉,因此要匹配到的字符数量减一
        p += 1
      }
    }
    if (l == -1) "" else s.substring(l, r + 1)
  }
}
