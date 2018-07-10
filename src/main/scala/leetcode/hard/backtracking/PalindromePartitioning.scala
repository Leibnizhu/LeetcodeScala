package leetcode.hard.backtracking

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/146/
  *
  * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
  * 返回 s 所有可能的分割方案。
  */
object PalindromePartitioning {
  type Result = List[List[String]]

  /**
    * 可以使用DFS(BFS好像也可以,但是队列会很复杂,为了减少空间复杂度还是DFS吧)
    * 从下下标0开始,找可以构成回文的子串,找到后,放入子串List,然后下标增加到回文子串后面,继续查找,查完后,把新子串删掉,继续下一条回文子串
    * 考虑到scala的List结构,可以反过来,从下标length-1开始向左搜索子串
    */
  def partition(s: String): Result = {
    /**
      * 判断字符串s下标从start到end的子串是否回文
      */
    def isPalindrome(s: String, start: Int, end: Int): Boolean =
      if (start >= end) true
      else if (s.charAt(start) == s.charAt(end)) isPalindrome(s, start + 1, end - 1)
      else false

    /**
      * 深度优先搜索,从start下标开始, 找可以构成回文的子串,
      * 找到后,放入curPath,然后下标增加到回文子串后面,继续查找,
      * 递归查完后,把新子串删掉,继续下一条回文子串
      *
      * @param s         搜索的字符串
      * @param end       开始搜索的下标
      * @param curPath   当前搜索的回文子串List
      * @param curResult 当前搜索到的结果集
      * @return 新的结果集
      */
    def dfs(s: String, end: Int, curPath: List[String], curResult: Result): Result = {
      if (end == -1) {
        curPath :: curResult //找到整个回文子串分割了,放入结果集
      } else {
        var result = curResult
        (end to 0 by -1).filter(isPalindrome(s, _, end)) //过滤可以构成回文子串的下标
          .foreach(i => result = dfs(s, i - 1, s.substring(i, end + 1) :: curPath, result)) //每一个下标深度搜索,更新结果集
        result
      }
    }

    dfs(s, s.length - 1, List(), List())
  }
}
