package codewars.kyu4

/**
  * 2022-06-03
  * {@see <a href='https://www.codewars.com/kata/54b72c16cd7f5154e9000457/train/scala'/> }
  */
object DecodeTheMorseCodeAdvanced {

  import codewars.kyu6.MorseCodes.morseCodes

  /**
    * 1.去头尾的0
    * 2.根据最短的连续数字推断速率
    * 3.按速率解码
    */
  def decodeBits(bits: String): String = {
    val cutHeadTail = bits.replaceAll("^0*", "").replaceAll("0*$", "")
    //如果全是1，那么就是一个.信号
    if (cutHeadTail.matches("1*")) "." else {
      val unit = math.min(
        cutHeadTail.split("0").map(_.length).filter(_ > 0).min,
        cutHeadTail.split("1").map(_.length).filter(_ > 0).min
      )
      val (dot, dash, charSep, wordSep) = ("1" * unit, "1" * 3 * unit, "0" * 3 * unit, "0" * 7 * unit)
      cutHeadTail.split(wordSep).map(_.replace(dash, "-").replace(dot, ".")
        .replace(charSep, " ").replace("0", "")).mkString("   ")
    }
  }

  def decodeMorse(morseCode: String): String = morseCode.trim.split(" {3}")
    .map(w => w.trim.split(" ").map(morseCodes).mkString)
    .mkString(" ")
}
