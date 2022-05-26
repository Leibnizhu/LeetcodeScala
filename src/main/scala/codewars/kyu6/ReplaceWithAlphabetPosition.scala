package codewars.kyu6

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/546f922b54af40e1e90001da/train/scala'/> }
  */
object ReplaceWithAlphabetPosition {
  def alphabetPosition(text: String): String = text.toLowerCase
    .toCharArray.filter(c => c >= 'a' && c <= 'z').map((_ - 'a' + 1)).mkString(" ")
}
