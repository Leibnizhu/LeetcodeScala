package codewars.kyu6

/**
  * 2022-05-26
  * {@see <a href='https://www.codewars.com/kata/51e0007c1f9378fa810002a9/train/scala'/> }
  */
object MakeTheDeadfishSwim {
  def parse(data: String): List[Int] = data.toCharArray.foldLeft(0, List[Int]())({
    case ((v, res), 'i') => (v + 1, res)
    case ((v, res), 'd') => (v - 1, res)
    case ((v, res), 's') => (v * v, res)
    case ((v, res), 'o') => (v, res :+ v)
  })._2
}
