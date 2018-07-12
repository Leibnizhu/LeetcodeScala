package leetcode.hard.backtracking

import scala.collection.mutable.ListBuffer

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/148/
  *
  * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
  * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
  */
object RemoveInvalidParentheses {
  /**
    * 有两种情况,一种是右括号多了,一种是左括号多了
    * 第一种情况,从左往右遍历字符,)的个数大于(的时候可以删除)了
    * 第二种情况类似,从右到左遍历字符,(的个数大于)的时候可以删除(
    * 那么要删除的时候其实有多种选择,所以可以用DFS或者BFS去搜索了
    * 但是删除的时候,比如)多了,此时每个)都可以删除,就会有重复的情况要处理重复的情况,
    * 首先要从递归调用的时候去掉相邻的同括号,另外可以传入本次删除的括号位置,下次从这里开始搜索
    * 最后,前面提到左右搜索都需要,所以同一层要搜一两次,第一次正向搜,第二次翻转字符串继续正向搜(等于反向搜)
    */
  def removeInvalidParentheses(s: String): List[String] = {
    /**
      * 深度优先搜索
      *
      * @param s    当前搜索的字符串
      * @param c    要判断多出来的括号类型,字符,正向搜的时候传入')',反向搜的时候传入'('
      * @param last 当前递归调用前删除的括号下标
      */
    def dfs(s: String, c: Char, last: Int, curRes: ListBuffer[String]): Unit = {
      var cnt = 0
      for (i <- 0 until s.length) {
        if (s.charAt(i) == ')' || s.charAt(i) == '(') if (s.charAt(i) == c) cnt -= 1 else cnt += 1 //统计括号匹配
        if (cnt < 0) { //出现失配
          for (j <- last to i) { //从上次删括号的位置开始,找可以删除的括号,进行递归dfs
            if (s.charAt(j) == c && (j == last || s.charAt(j - 1) != c)) //需要删除的括号类型,且与前面的括号不重复
              dfs(s.substring(0, j) + s.substring(j + 1), c, j, curRes) //删除j拼接新字符串
          }
          return
        }
      }
      if (c == ')') { //如果还没反向搜索,开始反向搜索
        dfs(s.reverse, '(', 0, curRes)
      } else { //反向搜索完,此时字符串是反的,需要翻转再加入结果集
        curRes += s.reverse
      }
    }

    val result = new ListBuffer[String]()
    dfs(s, ')', 0, result)
    result.toList
  }
}
