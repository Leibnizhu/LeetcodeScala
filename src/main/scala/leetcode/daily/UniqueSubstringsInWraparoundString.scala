package leetcode.daily

/**
  * 2022-05-25
  * {@see <a href='https://leetcode.cn/problems/unique-substrings-in-wraparound-string/'/> }
  */
object UniqueSubstringsInWraparoundString {
  /**
    * 首先一眼丁真鉴定为DP
    * s="abcdefghijklmnopqrstuvwxyz......" 无限循环，也就是说知道子串的 第一个字母 或 最后一个字母 及其 长度 就可以确定子串
    * 而同开头/结尾的子串，长的比如包括短的，所以比如如果知道 以a开头的的最长子串是 abc, 那么还包含子串 ab, a，一共3个，也就是 *开头的最长子串长度=*开头的子串数量
    * *结尾的子串数量同理
    * 那么是用*开头还是*结尾来算呢？显然，如果p从下标0开始遍历，那么拿到新的字符，可以得知/更新最长子串的结尾字母；反之，从p的最后向前遍历，就是知道/更新最长子串的开头字母
    * 也就是两种都可以。那么为了代码清晰，用 *结尾的子串最大长度来推断吧。
    * 设dp[*]=p中以*结尾的子串最大长度，那么 总字串数量= SUM(dp[*]) * in [a,z], dp[*]初始化为0，长度26,即空间复杂度O(1)
    * 而计算迭代dp，是遍历p，维护目前正在递增的子串长度，要注意a-z的衔接。
    * 即维护maxLen，遍历到p[i]，如果p[i]是p[i-1]的下一位字母，则maxLen++,否则maxLen=1; 且维护 dp[p[i]]=max(maxLen,dp[p[i]])
    */
  def findSubstringInWraproundString(p: String): Int = {
    val dp = Array.fill(26)(0)
    p.toCharArray.foldLeft((0, '.'))((s, curChar) => { //s = (当前最大子串长度, 上一个字符)
      val (maxLen, prevChar) = s
      val newMaxLen = if (prevChar != '.' && (curChar - prevChar == 1 || curChar - prevChar == -25)) maxLen + 1 else 1
      dp(curChar - 'a') = math.max(dp(curChar - 'a'), newMaxLen)
      (newMaxLen, curChar)
    })
    dp.sum
  }
}
