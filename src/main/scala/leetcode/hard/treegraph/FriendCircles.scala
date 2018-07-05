package leetcode.hard.treegraph

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/141/
  *
  * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
  * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
  * 注意：
  *  - N 在[1,200]的范围内。
  *  - 对于所有学生，有M[i][i] = 1。
  *  - 如果有M[i][j] = 1，则有M[j][i] = 1。
  */
object FriendCircles {
  type Graph = Array[Array[Int]]

  /**
    * BFS和DFS应该都可以,遍历所有人(就是M.length),每个人去BFS/DFS
    * 维护一个Set记录已经搜索到的人,搜索的时候,根据M找当前行所有1的放入Set,也就是这个人的朋友
    * 同时继续搜索原来不在Set里面的人,直到找不到新的人.
    * 遍历的时候如果在Set里面就跳过,不在Set里面搜索完之后朋友圈数量+1
    * 这里每个人其实都可以用下标表示,则HashSet可以用Boolean数组替代
    */
  def findCircleNum(M: Graph): Int = {
    val n = M.length //总人数
    val visited = Array.fill(n)(false) //已搜索到的人,对应M的下标
    /**
      * 处理队列queue,查找队列里的人所认识的朋友,修改visited记录
      */
    def bfs(m: Graph, queue: List[Int]): Unit = if (queue.nonEmpty) {
      val curPeople = queue.head
      visited(curPeople) = true //更新搜索记录
      bfs(m, queue.tail ++ (0 until n).filter(i => m(curPeople)(i) == 1 && !visited(i))) //队列去头,加上未处理的当前人朋友
    }

    /**
      * 遍历所有人,当前遍历curIndex,找到circles个朋友圈,返回新的朋友圈数
      */
    def findCircle(m: Graph, curIndex: Int, circles: Int): Int = curIndex match {
      case `n` => circles
      case i if visited(i) => findCircle(m, i + 1, circles)
      case _ => bfs(m, List(curIndex)); findCircle(m, curIndex + 1, circles + 1)
    }

    findCircle(M, 0, 0)
  }
}
