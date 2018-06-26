package leetcode.hard.arraystring

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/127/
  *
  * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
  * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
  *  - 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
  *  - 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
  *  - 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
  *  - 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
  * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
  *
  * 进阶:
  *  - 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
  *  - 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
  */
object CellularAutomata {
  /**
    * 主要难点在原地算法
    * 但是观察到输入是Int数组,实际上用到的只有0和1,那么可以用其他数字来代表状态的转换
    * 另外一方面,考虑到输入的定义1=活 0=死,以及输出的时候其他数字转换成结果的定义(与前面一样)
    * 可以定义4中状态,只要对2取模,得到的还是输入输出要求的定义
    * 0 - 死细胞变死细胞 兼容输入定义
    * 1 - 活细胞变活细胞 兼容输入定义
    * 2 - 活细胞变死细胞
    * 3 - 死细胞变活细胞
    */
  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val delta = Array((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)) //细胞周围8个位置的xy坐标delta
    val h = board.length
    val w = board(0).length
    for {i <- 0 until h; j <- 0 until w} yield {
      //统计周围活着的细胞数量
      var live = 0
      for (d <- delta) {
        val x = i + d._1
        val y = j + d._2
        if (x >= 0 && x < h && y >= 0 && y < w && (board(x)(y) == 1 || board(x)(y) == 2)) live += 1
      }
      //当前细胞没被处理过肯定为0或1,为0时如果有3个活细胞则复活(3)否则保持原状(0),为1时如果不是有2或3个细胞在死(2)否则保持原状(1)
      board(i)(j) = board(i)(j) match {
        case 0 if live == 3 => 3
        case 1 if live < 2 || live > 3 => 2
        case _ => board(i)(j)
      }
    }
    for {row <- board; i <- row.indices} row(i) %= 2 //转换矩阵为输出的定义
  }
}
