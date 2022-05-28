package codewars.kyu5

/**
  * 2022-05-28
  * {@see <a href='https://www.codewars.com/kata/55c6126177c9441a570000cc/train/scala'/> }
  */
object WeightForWeight {
  def orderWeight(strng: String): String = strng.split(" ")
    .sortWith((x, y) => {
      val (weightX, weightY) = (weight(x), weight(y))
      if (weightX == weightY) x < y else weightX < weightY
    }).mkString(" ")

  def weight(s: String): Int = s.split("").map(_.toInt).sum
}
