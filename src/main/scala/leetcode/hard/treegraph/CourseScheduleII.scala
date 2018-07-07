package leetcode.hard.treegraph

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/143/
  *
  * 现在你总共有 n 门课需要选，记为 0 到 n-1。
  * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
  * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
  * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
  * 说明:
  *  - 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
  *  - 你可以假定输入的先决条件中没有重复的边。
  * 提示:
  *  - 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
  *  - 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
  *  - 拓扑排序也可以通过 BFS 完成。
  */
object CourseScheduleII {
  /**
    * 类似CourseSchedule,不同的是,我们要记录去掉的0入度节点
    * 因此BFS搜索传递一个数组用来存储找到的节点即可(每次出队列的队头)
    * 但最后还要根据入度数组判断一下是否有环,有环则返回空数组
    */
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val degree = Array.fill(numCourses)(0) //入度,==-1表示已经遍历,删掉
    prerequisites.foreach(n => degree(n(0)) += 1) //统计入度
    val edges = prerequisites.groupBy(_ (1)).mapValues(_.map(_ (0))) //起点=>边的终点Array,先按起点分组,然后拿出终点组成数组
    def bfs(q: List[Int], result: List[Int]): List[Int] = if (q.isEmpty) result else {
      val next = edges.getOrElse(q.head, Array()) //当前点连接的点,没有出度的话,拿空数组可以正常继续下面的计算
      degree(q.head) = -1 //在入度数组中标记-1表示这个点删掉了
      next.foreach(n => degree(n) -= 1) //去掉当前点之后入度-1
      bfs(q.tail ++ next.filter(degree(_) == 0), result :+ q.head) //继续搜索那些新的入度为0的节点,同时当前队头加入结果集
    }

    //计算入度为0的节点,带下标zip是为了map的时候可以拿到节点ID, 开始搜索
    val result = bfs(degree.zipWithIndex.filter(_._1 == 0).map(_._2).toList, List())
    if (degree.count(_ != -1) == 0) result.toArray else Array() //最后看入度数组,如果全部是-1,则可以完成,返回结果,否则是不能完成,返回空数组
  }
}
