package leetcode.medium.treegraph

/**
  * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
  */
object NumberOfIslands {
  /**
    * 使用深度优先搜索DFS
    * 用一个等大的visited二维数组记录每个点是否已经处理过
    */
  def numIslands(grid: Array[Array[Char]]): Int = {
    /**
      * 深度优先搜索
      * 先判断当前i,j是否合法
      * 然后判断当前是否陆地,是否已经访问过
      * 如果都满足,则将当前点在visited中设为已访问
      * 并搜索周围四个点(根据题目定义,不考虑斜的方向)
      */
    def dfs(grid: Array[Array[Char]], visited: Array[Array[Boolean]], x: Int, y: Int): Unit = {
      if (x >= 0 && x < grid.length && y >= 0 && y < grid(0).length
        && grid(x)(y) == '1' && !visited(x)(y)) {
        visited(x)(y) = true
        dfs(grid, visited, x - 1, y)
        dfs(grid, visited, x + 1, y)
        dfs(grid, visited, x, y - 1)
        dfs(grid, visited, x, y + 1)
      }
    }

    if (grid.isEmpty || grid(0).isEmpty) {
      0
    } else {
      val h = grid.length //高度
      val w = grid(0).length //宽度
      var islands = 0
      val visited = Array.ofDim[Boolean](h, w)
      //遍历所有点
      for {
        i <- 0 until h
        j <- 0 until w
      } yield {
        if (grid(i)(j) == '1' && !visited(i)(j)) { //跳过已经处理过的和海,同一个岛会在一次dfs里面处理完
          dfs(grid, visited, i, j)
          islands += 1
        }
      }
      islands
    }
  }
}
