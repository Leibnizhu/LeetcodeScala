package codewars.kyu4

/**
  * 2022-05-31
  * {@see <a href='https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/scala'/> }
  */
object HumanReadableDurationFormat {
  def formatDuration(seconds: Int): String = {
    val (second, minute, hour, day, year) = (seconds % 60, seconds / 60 % 60, seconds / 60 / 60 % 24, seconds / 60 / 60 / 24 % 365, seconds / 60 / 60 / 24 / 365)
    val res = scala.collection.mutable.ListBuffer[String]()
    if (second != 0) res += s"$second second${if (second > 1) "s" else ""}"
    if (minute != 0) res += s"$minute minute${if (minute > 1) "s" else ""}"
    if (hour != 0) res += s"$hour hour${if (hour > 1) "s" else ""}"
    if (day != 0) res += s"$day day${if (day > 1) "s" else ""}"
    if (year != 0) res += s"$year year${if (year > 1) "s" else ""}"
    res.toList match {
      case Nil => "now"
      case List(single) => single
      case list => s"${list.tail.reverse.mkString(", ")} and ${res.head}"
    }
  }
}
