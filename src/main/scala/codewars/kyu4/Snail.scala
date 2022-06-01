package codewars.kyu4

/**
  * 2022-05-31
  * {@see <a href='https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/scala'/> }
  */
object Snail {
  /**
    * n = xs.size/2
    * 第round圈，下标范围 [min,max]
    * 画图推算:
    *  1. n=偶数时， min=n/2-round,max=n/2+round-1
    *     2. n=奇数时， min=n/2-round+1,max=n/2+round-1
    *     每圈拿的座标范围：
    *     (min, [min, max-1])
    *     ([min, max-1], max)
    *     (max, [max,min+1])
    *     ([max,min+1], min)
    *     每条边拿 max-min个
    *
    * @param round 第N圈，从中间开始算为1
    *              xs.size=奇数则 round=[1,(n+1)/2]
    *              xs.size=偶数则 round=[1,n/2]=[1,(n+1)/2]
    * @return 第round圈的顺时针数字
    */
  def snail(xs: List[List[Int]], round: Int): List[Int] = {
    val n = xs.size
    val min = if (n % 2 == 0) n / 2 - round else n / 2 - round + 1
    val max = n / 2 + round - 1
    if (min == max) { //最中间一个round，即n=奇数时的round=1
      List(xs(min)(min))
    } else {
      ((min until max).map(xs(min)(_)) ++
        (min until max).map(xs(_)(max)) ++
        (max until min by -1).map(xs(max)(_)) ++
        (max until min by -1).map(xs(_)(min))).toList
    }
  }

  def snail(xs: List[List[Int]]): List[Int] = if (xs.isEmpty || xs.head.isEmpty) List() else
    ((xs.length + 1) / 2 to 1 by -1).flatMap(snail(xs, _)).toList //从外到内一圈圈遍历再拼起来
}
