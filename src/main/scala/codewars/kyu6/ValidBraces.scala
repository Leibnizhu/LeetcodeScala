package codewars.kyu6

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/scala'/> }
  */
object ValidBraces {
  def validBraces(s: String): Boolean = {
    val res = s.toCharArray.foldLeft((List[Char](), true))((s, c) => if (!s._2) s else c match {
      case '(' | '[' | '{' => (c :: s._1, true)
      case ')' => rightBrace('(', s)
      case ']' => rightBrace('[', s)
      case '}' => rightBrace('{', s)
    })
    res._2 && res._1.isEmpty
  }

  def rightBrace(l: Char, s: (List[Char], Boolean)): (List[Char], Boolean) =
    if (s._1.nonEmpty && s._1.head == l) (s._1.tail, true) else (s._1, false)
}
