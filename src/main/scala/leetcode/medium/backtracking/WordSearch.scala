package leetcode.medium.backtracking

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/95/
  *
  * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
  * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
  */
object WordSearch {
  /**
    * 深度优先搜索
    */
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    /**
      * 深度优先搜索
      * @param board   地图
      * @param word    要查找的单词
      * @param visited 当前有效已读过的地图
      * @param n       当前匹配到单词的第几个
      * @param x       当前读取的地图x坐标, 对应高
      * @param y       当前读取的地图y坐标, 对应宽
      * @return
      */
    def dfs(board: Array[Array[Char]], word: String, visited: Array[Array[Boolean]])
           (n: Int, x: Int, y: Int): Boolean = {
      if (n == word.length) //收敛条件,已查找到
        true
      else if (x < 0 || x >= board.length || y < 0 || y >= board(0).length) //越界
        false
      else if (visited(x)(y)) // 已经查过,剪枝
        false
      else if (word.charAt(n) != board(x)(y)) //不相等,剪枝
        false
      else { // 当前位置可匹配,继续查下一个
        visited(x)(y) = true
        val curRes = dfs(board, word, visited)(n + 1, x - 1, y) ||
          dfs(board, word, visited)(n + 1, x + 1, y) ||
          dfs(board, word, visited)(n + 1, x, y - 1) ||
          dfs(board, word, visited)(n + 1, x, y + 1) //向四个方向查找,只要有一个成功就行
        visited(x)(y) = false //当前节点失败,不能进一步匹配,要在visited中去掉,避免其他节点查找到的时候跳过
        curRes
      }
    }

    val h = board.length //高
    val w = board(0).length //宽
    val visited = Array.ofDim[Boolean](h, w) //记录每个点是否读过
    for { //遍历每一个点,分别去深度优先搜索(当然,有visited帮忙剪枝)
      i <- 0 until h
      j <- 0 until w
    } yield if (dfs(board, word, visited)(0, i, j)) return true //找到了直接返回
    false
  }
}
