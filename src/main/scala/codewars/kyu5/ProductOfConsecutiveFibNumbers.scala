package codewars.kyu5

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/scala'/> }
  */
object ProductOfConsecutiveFibNumbers {
  @scala.annotation.tailrec
  def productFib(prod: Long, l: Long = 0, r: Long = 1): Array[Long] = {
    val product = l * r
    if (product < prod) {
      productFib(prod, r, l + r)
    } else if (product == prod) {
      Array(l, r, 1)
    } else {
      Array(l, r, 0)
    }
  }
}
