package codewars.kyu7

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/train/scala'/> }
  */
object Mumbling {
  def accum(s: String) = s.toLowerCase.toCharArray.zipWithIndex
    .map(c => (c._1.toString * (c._2 + 1)).capitalize)
    .mkString("-")
}