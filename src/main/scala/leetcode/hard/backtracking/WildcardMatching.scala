package leetcode.hard.backtracking

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/149/
  *
  * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
  *  - '?' 可以匹配任何单个字符。
  *  - '*' 可以匹配任意字符串（包括空字符串）。
  * 两个字符串完全匹配才算匹配成功。
  * 说明:
  *  - s 可能为空，且只包含从 a-z 的小写字母。
  *  - p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
  */
object WildcardMatching {
  /**
    * 直接按通配符的定义去递归会超时(一个个匹配,普通字符相等则递归匹配,*则分情况)
    * 可以用动态规划,遍历p,用一个数组记录当前s每个字符匹配的情况(针对当前p,比如第一次遍历匹配p(0),第二次遍历匹配p(0,1))
    * 遇到*的话,上一轮匹配好的字符之后都可以匹配上,所以 f(j) = f(j - 1) || f(j),从左到右更新f
    * 遇到其他字符,则要么字符匹配要么跟?匹配,同时前提是上一位已经匹配
    * 参考了,https://blog.csdn.net/glDemo/article/details/47678159,将二维的动态规划数组优化为1维的
    */
  def isMatch(s: String, p: String): Boolean = {
    val (m, n) = (s.length, p.length)
    val stars = p.toCharArray.count(_ == '*') //*的个数
    if (stars == 0 && m != n) {
      false //没有通配符,长度不一致,肯定不匹配
    } else if (n - stars > m) {
      false //匹配字符串去掉星号之后比待匹配的还长,肯定不匹配
    } else {
      val status = Array.fill(m + 1)(false) //默认都为false
      status(0) = true //初始状态
      for (c <- p.toCharArray) c match {
        case '*' => for (j <- 1 to m) //遇到通配符,可以认为后面的全部都可以匹配
          status(j) = status(j - 1) || status(j) //如果前面的已经匹配上,那么遇到*依旧可以匹配
        case _ => for (j <- m to 1 by -1) //依赖前一位,为了避免覆盖旧结果,从尾部向前遍历
          status(j) = (c == '?' || c == s.charAt(j - 1)) && status(j - 1) //当前字符匹配上或遇到?通配符,同时前一位要匹配上才行
          status(0) = false //第一次遇到非*符,应该把初始条件去掉,靠后面匹配的情况来继续迭代计算
      }
      status(m)
    }
  }
}
