package leetcode.hard.treegraph

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/138/
  *
  * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
  * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
  * 解释:
  * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
  */
object SurroundedRegions {
  type Board = Array[Array[Char]]
  val RESERVED = 'R'

  /**
    * 可以广度优先搜索.
    * 从上下左右四条边所有点往里面搜索,找到不与边界接壤O要改成X
    * 为了记录已经被处理的,避免搜索过程中提前改X引起误判断漏掉造成孤岛,
    * 应该加入一个临时状态R(Reserved),表示需要保留的O,最后遍历board把R改成O
    */
  def solve(board: Board): Unit = {
    case class State(x: Int, y: Int) { //记录处理的点
      //判定当前点可是否作为下一步,首先xy范围要正确,其次要是O
      def isValid: Boolean = x >= 0 && x < board.length && y >= 0 && y < board(0).length && board(x)(y) == 'O'
      def reserve(): Unit = board(x)(y) = RESERVED //当前点标记为保留

      /**
        * 查找cur点下一步可走的O点,需要查找上下左右四个方向,判定是否可用,同时标记非孤岛的O点
        */
      def >>(board: Board): List[State] = {
        val next = List(State(x + 1, y), State(x - 1, y), State(x, y + 1), State(x, y - 1)).filter(_.isValid)
        next.foreach(_.reserve()) //非孤岛的O点,最后遍历的时候需要保留
        next
      }
    }

    /**
      * 从x=i,y=j开始广度优先搜索; queue是待处理的队列,返回处理后的队列
      */
    def search(board: Board, i: Int, j: Int): Unit = {
      def bfs(board: Board, queue: List[State]): Unit =
        if (queue.nonEmpty)
          bfs(board, queue.tail ++ (queue.head >> board))

      val start = State(i, j)
      if (start.isValid) { //起始状态,因为从边开始,如果是O才要去搜索
        board(i)(j) = RESERVED
        bfs(board, List(start))
      }
    }

    if (board.nonEmpty) {
      val m = board.length //高,对应i,x
      val n = board(0).length //宽,对应j,y
      (0 until n).foreach(search(board, 0, _)) //第一行
      (0 until n).foreach(search(board, m - 1, _)) //最后一行
      (1 to m - 2).foreach(search(board, _, 0)) //第一列
      (1 to m - 2).foreach(search(board, _, n - 1)) //最后一列
      for {i <- 0 until m; j <- 0 until n} yield board(i)(j) = board(i)(j) match {
        case 'O' => 'X' //孤岛置为X
        case RESERVED => 'O' //恢复
        case _ => 'X'
      }
    }
  }
}
