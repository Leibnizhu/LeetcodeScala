package codewars.kyu4

/**
  * 2022-06-12
  * {@see <a href='https://www.codewars.com/kata/5629db57620258aa9d000014/train/scala'/> }
  */
object StringsMix {
  def mix(s1: String, s2: String): String = {
    def wc(s: String): Map[Char, Int] = s.replaceAll("[^a-z]", "").toCharArray
      .groupBy(c => c).map(t => (t._1, t._2.length))

    val (s1Map, s2Map) = (wc(s1), wc(s2))
    ('a' to 'z')
      .map(c => (s1Map.getOrElse(c, 0), s2Map.getOrElse(c, 0)) match {
        case (c1, c2) if c1 <= 1 && c2 <= 1 => null
        case (c1, c2) if c1 > c2 => ('1', c, c1)
        case (c1, c2) if c1 < c2 => ('2', c, c2)
        case (c1, c2) if c1 == c2 => ('=', c, c1)
      }).filter(_ != null)
      .sortBy(t => (-t._3, t._1))
      .map(t => s"${t._1}:${t._2.toString * t._3}")
      .mkString("/")
  }
}
