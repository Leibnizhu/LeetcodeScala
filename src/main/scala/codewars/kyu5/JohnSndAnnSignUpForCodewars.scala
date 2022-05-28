package codewars.kyu5

import scala.collection.mutable

/**
  * 2022-05-28
  * {@see <a href='https://www.codewars.com/kata/57591ef494aba64d14000526/train/scala'/> }
  */
object JohnSndAnnSignUpForCodewars {
  def jnArr(n: Int): (List[Int], List[Int]) = {
    val (j, a) = (mutable.ListBuffer(0), mutable.ListBuffer(1))
    for (x <- 1 until n) {
      j += (x - a(j(x - 1)))
      a += (x - j(a.apply(x - 1)))
    }
    (j.toList, a.toList)
  }

  def john(n: Long): String = jnArr(n.toInt)._1.mkString(", ")

  def ann(n: Long): String = jnArr(n.toInt)._2.mkString(", ")

  def sumJohn(n: Long): Long = jnArr(n.toInt)._1.sum

  def sumAnn(n: Long): Long = jnArr(n.toInt)._2.sum
}
