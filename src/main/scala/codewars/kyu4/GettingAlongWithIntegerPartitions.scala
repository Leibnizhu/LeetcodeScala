package codewars.kyu4


/**
  * 2022-06-04
  * {@see <a href='https://www.codewars.com/kata/55cf3b567fc0e02b0b00000b/train/scala'/> }
  */
object GettingAlongWithIntegerPartitions {
  /**
    * 一种方案是DFS求所有可能，分别求乘积放入Set，再算那几个指标
    * 还可以用DP，memo[n]:Set[Int]定义为n的所有整数组合的各自乘积的集合
    * 设 productSet(a:Set,b:Set):Set=a每个元素和b每个元素两两相乘的结果的集合
    * memo[1]=Set(1)
    * memo[n]=Set(n) ∪ productSet(memo[1],memo[n-1]) ∪ productSet(memo[2],memo[n-2]) ∪......
    */
  def part(n: Long): String = {
    def productSet(a: Set[Int], b: Set[Int]): Set[Int] = for {
      aEle <- a
      bEle <- b
    } yield (aEle * bEle)

    val memo = new Array[Set[Int]](n.toInt)
    memo(0) = Set(1)
    for (i <- 1 until n.toInt) {
      val tmpSet = new scala.collection.mutable.HashSet[Int]()
      tmpSet += (i + 1)
      for (j <- 0 to i / 2) {
        tmpSet ++= productSet(memo(j), memo(i - j - 1))
      }
      memo(i) = tmpSet.toSet
      println(n, i, memo(i))
    }
    val res = memo(n.toInt - 1).toList.sorted
    val range = res.last - res.head
    val avg = res.map(_.toDouble).sum / res.size
    val median = (res((res.length - 1) / 2) + res(res.length / 2)) / 2.0
    f"Range: $range Average: $avg%.2f Median: $median%.2f"
  }
}
