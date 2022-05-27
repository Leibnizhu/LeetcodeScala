package codewars.kyu6

/**
  * 2022-05-27
  * {@see <a href='https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/scala'/> }
  */
object YourOrderPlease {
  def order(str: String): String = str.split(" ")
    .sortBy(s => s.toCharArray.filter(c => c >= '1' && c <= '9').map(_.toInt).take(1)(0))
    .mkString(" ")
}
