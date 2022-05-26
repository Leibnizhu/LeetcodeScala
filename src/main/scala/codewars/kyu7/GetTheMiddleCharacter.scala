package codewars.kyu7

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/56747fd5cb988479af000028/train/scala'/> }
  */
object GetTheMiddleCharacter {
  def middle(s: String): String =
    s.substring((s.length - 1) / 2, s.length / 2 + 1)
}
