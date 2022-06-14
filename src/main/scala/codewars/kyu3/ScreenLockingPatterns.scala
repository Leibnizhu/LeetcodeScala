package codewars.kyu3

/**
  * 2022-06-14
  * {@see <a href='https://www.codewars.com/kata/585894545a8a07255e0002f1/train/scala'/> }
  */
object ScreenLockingPatterns {
  val cannotConnect: Set[(Int, Int)] = Set((0, 2), (3, 5), (6, 8), (0, 6), (1, 7), (2, 8), (0, 8), (2, 6))

  /**
    * 关于是否跨过，可以通过 (起点+终点)/2 == 中间点 评断
    */
  def countPatternsFrom(f: Char, l: Int): Int = if (l <= 1) l else {
    val visited = Array.fill[Boolean](9)(false)

    def canVisit(curIndex: Int, nextIndex: Int): Boolean = if (visited(nextIndex)) false
    else if (cannotConnect.contains((curIndex, nextIndex)) || cannotConnect.contains((nextIndex, curIndex))) {
      visited((curIndex + nextIndex) / 2) //中点已被访问，可以跨过
    } else true //没被访问过且不在不能跨的点里，可以访问

    def dfs(curIndex: Int, leftStep: Int, matched: Int): Int = if (leftStep == 0) matched + 1 else {
      (0 until 9)
        .filter(canVisit(curIndex, _))
        .foldLeft(matched)((c, nextIndex) => {
          visited(nextIndex) = true
          val newMatch = dfs(nextIndex, leftStep - 1, c)
          visited(nextIndex) = false
          newMatch
        })
    }

    visited(f - 'A') = true
    dfs(f - 'A', l - 1, 0)
  }
}
