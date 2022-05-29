package codewars.kyu5

/**
  * 2022-05-29
  * {@see <a href='https://www.codewars.com/kata/55e7280b40e1c4a06d0000aa/train/scala'/> }
  */
object BestTravel {
  def chooseBestSum(t: Int, k: Int, ls: List[Int]): Int = {
    def bfs(n: Int, curSet: List[Int], curResult: Int): Int =
      if (curSet.size == k) {
        val sum = curSet.sum
        if (sum > t) -1
        else if (sum == t) sum
        else math.max(sum, curResult)
      } else if (n >= ls.size) -1
      else {
        val tmpRes = bfs(n + 1, curSet :+ ls(n), curResult) //当前数字选择加入子集
        if (tmpRes == t) t else math.max(tmpRes,bfs(n + 1, curSet, tmpRes)) //当前数字选择不加入子集
      }

    bfs(0, List(), -1)
  }
}
