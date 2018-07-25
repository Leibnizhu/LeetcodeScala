package leetcode.hard.other

import java.util.PriorityQueue

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/168/
  *
  * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
  * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
  * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
  * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
  * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
  *
  * 说明:
  *  - 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
  *  - 输入列表已经按升序排列在左边的 x 位置 Li 。
  *  - 输出列表必须按 x 位排序。
  *  - 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
  */
object SkyLine {
  /**
    * 根据输出结果的关键点定义,结合例子的图像,发现关键点应该从左到右是当前最高点发生变化时生成
    * 比如第一个蓝色矩形,从0高度变成10,产生关键点(2,10),
    * 出现红色矩形,最高点从10变成15,产生关键点(3,15)
    * 到红色矩形结束时,最高点从15变成12,生成新关键点(7,12)
    * 所以我们要一个值或数据结构来存储当前的最高点,当对应的矩形右端点出现时,最高点会发生变化,此时要拿到次高点
    * 因此用一个值无法存储,从上一句话分析,我们需要的是拿到每一个时刻的最大值,因此可以用一个最大堆实现
    * 按天际线和关键点的定义,只处理矩形的左上和右上端点,把这些点按横坐标升序排序进行遍历(相当于从左到右扫描天际线)
    * 遇到左端点入堆,遇到右端点把对应的左端点出堆,然后判断堆顶(当前最高值)是否发生变化,发生变化则增加关键点
    *
    * 为了从堆中找回右端点对应的左端点,可以弄一个父类Point,两个case class代表左右端点
    * 但这样堆的结构就比较复杂,效率比较低;考虑到关键点只考虑高度,而且没有负高度的建筑,
    * 因此堆里面可以只保留高度信息(Int),且左端点正常记录坐标,右端点把y值记为负数,
    * 这样遍历端点数组时可以分辨是左还是右端点,同时右端点可以找到对应的左端点高度,从而从堆中移除
    */
  def getSkyline(buildings: Array[Array[Int]]): List[Array[Int]] = {
    val sortedPoints = buildings.flatMap(p => Array((p(0), p(2)), (p(1), -p(2)))) //拆分左右端点
      .sortWith((l, r) => if (l._1 == r._1) l._2 > r._2 else l._1 < r._1) //根据x坐标升序排序,x相同时按高度降序
    val maxHeap = new PriorityQueue[Int]((i1, i2) => i2 - i1) //scala的PriorityQueue不支持删除,所以用了java的
    maxHeap.offer(0) //地平线,这样第一个楼才能正确计算
    sortedPoints.foldLeft((0, List[Array[Int]]())) { case ((prevHeight, result), (x, y)) =>
      if (y > 0) maxHeap.offer(y) else maxHeap.remove(-y) //左端点插入堆,右端点从堆中移除对应左端点
      val curHeight = maxHeap.peek
      if (prevHeight != curHeight) //最大高度发生变化,则生成新的关键点插入到结果集中
        (curHeight, result :+ Array(x, curHeight)) //关键点坐标为:(当前点的x坐标,当前最大高度)
      else
        (prevHeight, result)
    }._2
  }

  /**
    * val maxHeap = new PriorityQueue[Int]((i1, i2) => i2 - i1)
    * 在leetcode网站上可能会报错,需要改成:
    * val maxHeap = new PriorityQueue[Int](new Comparator[Int]() {
    * override def compare(i1: Int, i2: Int): Int = i2 - i1
    * })
    */
}