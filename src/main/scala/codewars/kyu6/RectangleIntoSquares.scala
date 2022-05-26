package codewars.kyu6

import scala.annotation.tailrec

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/55466989aeecab5aac00003e/train/scala'/> }
  */
object RectangleIntoSquares {
  def sqInRect(min: Int, max: Int): Array[Int] = {
    @tailrec
    def f(l: Int, s: Int, res: Array[Int]): Array[Int] = if (l == s) res :+ l else {
      val newL = l - s
      if (newL > s) f(newL, s, res :+ s) else f(s, newL, res :+ s)
    }

    if(max==min) Array() else if (max > min) f(max, min, Array()) else f(min, max, Array())
  }
}
