package codewars.kyu7

/**
  * 2022-05-25
  * {@see <a href='https://www.codewars.com/kata/5656b6906de340bd1b0000ac/train/scala'/> }
  */
object TwoToOne {
  def longest(s1: String, s2: String): String = new String((s1.toCharArray ++ s2.toCharArray).distinct.sorted)
}
