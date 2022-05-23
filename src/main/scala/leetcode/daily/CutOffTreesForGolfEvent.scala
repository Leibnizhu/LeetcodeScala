package leetcode.daily

/**
  * 2022-05-23
  * {@see <a href='https://leetcode.cn/problems/cut-off-trees-for-golf-event/'/> }
  */
object CutOffTreesForGolfEvent {
  val directions: Array[(Int, Int)] = Array((-1, 0), (1, 0), (0, -1), (0, 1)) //每一步要走的方向

  /**
    * 找树，排序，多次bfs累加
    */
  def cutOffTree(forest: List[List[Int]]): Int = {
    val (m, n) = (forest.size, forest.head.size) //行数,列数
    val trees = forest.zipWithIndex.flatMap(r => r._1.zipWithIndex.map(c => (c._1, (r._2, c._2)))) //转(数字,(行,列))
      .filter(_._1 > 1).sortBy(_._1).map(_._2) //过滤树，排序,座标

    def bfs(fromX: Int, fromY: Int, toX: Int, toY: Int): Int = {
      if (fromX == toX && fromY == toY) {
        0
      } else {
        var step = 0
        val queue = new scala.collection.mutable.Queue().enqueue((fromX, fromY))
        val visited = Array.fill(m, n)(false)
        visited(fromX)(fromY) = true
        while (queue.nonEmpty) {
          step += 1 //bfs一层算一步
          val curQueueSize = queue.size //不能直接遍历，
          for (i <- 1 to curQueueSize) {
            val p = queue.dequeue()
            for (direction <- directions) { //遍历4个方向
              val (nextX, nextY) = (p._1 + direction._1, p._2 + direction._2) //该方向的下一个点
              if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited(nextX)(nextY) && forest(nextX)(nextY) > 0) { //点座标合法性判断,及未被访问、不是墙
                if (nextX == toX && nextY == toY) { //到达目的地
                  return step
                }
                queue.enqueue((nextX, nextY))
                visited(nextX)(nextY) = true
              }
            }
          }
        }
        -1
      }
    }

    var (x, y, steps) = (0, 0, 0)
    for (tree <- trees) {
      val curStep = bfs(x, y, tree._1, tree._2)
      if (curStep == -1) return -1 //有一步不能到达就应该退出
      steps += curStep
      x = tree._1
      y = tree._2
    }
    steps
  }
}
