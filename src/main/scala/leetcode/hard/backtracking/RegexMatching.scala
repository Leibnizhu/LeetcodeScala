package leetcode.hard.backtracking

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/150/
  *
  * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
  *  - '.' 匹配任意单个字符。
  *  - '*' 匹配零个或多个前面的元素。
  * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
  * 说明:
  *  - s 可能为空，且只包含从 a-z 的小写字母。
  *  - p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
  */
object RegexMatching {
  /**
    * 可以在通配符匹配的题目上面进行修改, 但推想了一下,需要上两次状态才行(*的特性),要么用n*n的二维数组,空间O(n*n)
    * 要么维护两个长度为n的数组,但是写起来很复杂因为每次都要操作着两个数组,还要小心不要被覆盖数值
    * 尝试一下直接递归,没想到可以过
    * 原理很简单,递归终结条件是p匹配遍历完的时候,s已经全匹配上,则可以匹配,否则s还有没匹配完的就是匹配不上
    * 递归的时候,要考虑*,如果遇到下一个字符是*,由于可以匹配0个或多个,所以:
    *  - 要么匹配0个字符,p串跳过当前两个字符
    *  - 要么匹配多个,先匹配当前一个字符(可以匹配上的话),然后s向前一位,p不动,继续递归处理
    * 否则如果下一个不是*的话,正常匹配,看字符相等或p是.句号,则s和p同时向前1位,继续递归匹配
    */
  def isMatch(s: String, p: String): Boolean = {
    def matching(s: String, si: Int)(p: String, pi: Int): Boolean =
      if (pi >= p.length) {
        si >= s.length //目标串已经走完,源串也匹配完的话就是可以匹配上,否则匹配不上
      } else {
        val curByteMatch = si < s.length && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') //当前字符是否匹配
        if (pi < p.length - 1 && p.charAt(pi + 1) == '*') //如果下一个是*,那么要么*匹配0个直接pi+2,要么匹配s一个字符,继续匹配
          matching(s, si)(p, pi + 2) || (curByteMatch && matching(s, si + 1)(p, pi))
        else //第二个字符不为*,比较当前字符是否相等，然后继续递归后面的字符串
          curByteMatch && matching(s, si + 1)(p, pi + 1)
      }

    matching(s, 0)(p, 0)
  }
}
