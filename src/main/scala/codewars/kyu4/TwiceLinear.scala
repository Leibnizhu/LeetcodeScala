package codewars.kyu4


/**
  * 2022-06-09
  * {@see <a href='https://www.codewars.com/kata/5672682212c8ecf83e000050/train/scala'/> }
  */
object TwiceLinear {
  /**
    * 维护一个List，每次算两个数组的较小者放进去
    * 同时维护两个数组目前的下标
    */
  def dblLinear(n: Int): Int = {
    val result = new scala.collection.mutable.TreeSet[Int]()
    result += 1
    for (i <- 0 until n) {
      val x = result.firstKey
      result += 2 * x + 1
      result += 3 * x + 1
      result -= x
    }
    result.firstKey

    //这种会超时
    /*var (x, y) = (0, 0) //两个数组的下标,
    val result = new scala.collection.mutable.ListBuffer[Int] //合并后的数组
    result += 1
    for (i <- 0 until n) {
      (2 * result(x) + 1, 3 * result(y) + 1) =fmatch {
        case (a, b) if a > b => result += b; y += 1
        case (a, b) if a < b => result += a; x += 1
        case (a, b) if a == b => result += a; x += 1; y += 1
      }
    }
    result.last
    */
  }
}
