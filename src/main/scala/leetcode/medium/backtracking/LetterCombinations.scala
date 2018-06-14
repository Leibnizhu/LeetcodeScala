package leetcode.medium.backtracking

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/91/
  *
  * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
  * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
  * 说明:  尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
  */
object LetterCombinations {
  /**
    * 回溯法
    */
  def letterCombinations(digits: String): List[String] = {
    //每个按钮对应的字母,为了方便查询,前面加了两个空的,这样下标2直接对应按钮2的字母
    val dict = Array("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    /**
      * 根据参数组进行组合
      * 如果n=digits长度则拿到一个结果,直接加入到结果集并返回
      * 否则拿到当前按键对应的字母,分别调用combine,每调用一次自动回溯,curCombine记录着要回溯的初始状态
      *
      * @param digits 输入的字符串
      * @param n 当前遍历digits的第n个字符
      * @param curCombine 调用函数前已经组合到的字符串
      * @param result 调用函数前已经拿到的结果集
      * @return 结果集
      */
    def combine(digits:String, n:Int, curCombine:String, result:List[String]):List[String]={
      if(n == digits.length){ //拼接完,返回
        result :+ curCombine
      } else {
        val curDict = dict(digits.charAt(n) - '0') //当前按钮对应的可能字母
        var curResult = result
        for(i <- 0 until curDict.length){
          val newCombine = curCombine + curDict.charAt(i) //组合的单词增加新字母
          curResult = combine(digits, n+1, newCombine, curResult)
          //结束之后就自动回溯了,因为这里纯函数, curCombine没有被修改,所以newCombine直接在curCombine基础上加新字母就行
        }
        curResult
      }
    }
    if(digits == null || digits.isEmpty) List() else combine(digits, 0, "", List())
  }
}
