package codewars.kyu6

/**
  * 2022-06-03
  * {@see <a href='https://www.codewars.com/kata/54b724efac3d5402db00065e/train/scala'/> }
  */
object DecodeTheMorseCode {
  import MorseCodes.morseCodes

  def decode(msg: String) = msg.trim.split(" {3}")
    .map(w => w.trim.split(" ").map(c=>if("···−−−···"==c)"SOS"else morseCodes(c)).mkString)
    .mkString(" ")

}
