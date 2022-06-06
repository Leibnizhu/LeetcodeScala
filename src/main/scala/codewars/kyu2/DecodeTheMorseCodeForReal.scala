package codewars.kyu2

/**
  * 2022-06-06
  * {@see <a href='https://www.codewars.com/kata/54acd76f7207c6a2880012bb/train/scala'/> }
  */
object DecodeTheMorseCodeForReal {

  import codewars.kyu6.MorseCodes.MORSE_CODE

  case class Range(var min: Int, var max: Int)

  val dotPauseThreshold = 0.23
  val dashPauseThreshold = 0.59
  val dotThreshold = 0.48

  def decodeBitsAdvanced(bits: String): String = {
    val cutHeadTail = bits.replaceAll("^0*", "").replaceAll("0*$", "")
    //如果全是1，那么就是一个.信号
    if (cutHeadTail.matches("1*")) "." else {
      val zeroLengths = cutHeadTail.split("1").map(_.length).filter(_ > 0).distinct.sorted
      val oneLengths = cutHeadTail.split("0").map(_.length).filter(_ > 0).distinct.sorted
      val dotPause = Range(zeroLengths.head, 0)
      val dashPause = Range(0, 0)
      val space = Range(0, zeroLengths.last)
      val dot = Range(oneLengths.head, 0)
      val dash = Range(0, oneLengths.last)

      //间隔的长度范围
      val zeroDiff = zeroLengths.last - zeroLengths.head
      for (len <- zeroLengths) {
        if (len <= zeroLengths.head + zeroDiff * dotPauseThreshold) {
          dotPause.max = len;
          dashPause.min = len + 1
        }
        if (len <= zeroLengths.head + zeroDiff * dashPauseThreshold) {
          dashPause.max = len;
          space.min = len + 1
        }
      }
      if (dashPause.min > dashPause.max) {
        dashPause.min = dashPause.max
      }
      if (space.min > space.max) {
        space.min = space.max
      }

      // 点和横的长度范围
      val oneDiff = oneLengths.last - oneLengths.head
      var goOnLoop = true
      for (len <- oneLengths if goOnLoop) {
        if (len <= oneLengths.head + oneDiff * dotThreshold) {
          dot.max = len;
          dash.min = len + 1
        }
        goOnLoop = false
      }
      if (dash.min > dash.max) {
        dash.min = dash.max
      }

      println(s"space=$space\ndotPause=$dotPause, dot=$dot\ndashPause=$dashPause, dash=$dash")

      var result = bits
      if (dash.min != dot.max || (dashPause.max > 0 && dash.min > dashPause.max * 2)) {
        result = result.replaceAll("1{" + dash.min + "," + dash.max + "}", "-")
      }
      //dots
      result = result.replaceAll("1{" + dot.min + "," + dot.max + "}", ".")

      //spaces between words
      if (space.min != dashPause.max || (dot.max > 0 && space.min > dot.max * 4)) {
        result = result.replaceAll("0{" + space.min + "," + space.max + "}", "   ")
      }

      //spaces between letters
      if (dashPause.min != dotPause.max || (dot.max > 0 && dashPause.min > dot.max * 1.5)) {
        result = result.replaceAll("0{" + dashPause.min + "," + dashPause.max + "}", " ")
      }

      //spaces between parts
      result = result.replaceAll("0{" + dotPause.min + "," + dotPause.max + "}", "")
      println(result)
      println(decodeMorse(result))


      val Array(sUnit, bUnit) = (cutHeadTail.split("0").map(_.length).filter(_ > 0) ++
        cutHeadTail.split("1").map(_.length).filter(_ > 0)).distinct.sorted.take(2)
      cutHeadTail.split("0{" + space.min + "," + space.max + "}")
        .map(_
          .replaceAll("0{" + sUnit * 3 + "," + (bUnit * 3 + 1) + "}", " ") //字母间隔
          .replaceAll("1{" + (sUnit * 3 + 1) + "," + (bUnit * 3 + 1) + "}", "-")
          .replaceAll("1{" + sUnit + "," + (bUnit + 1) + "}", ".")
          .replace("0", "")
        ).mkString("   ")
    }
  }

  def decodeMorse(morseCode: String): String = morseCode.trim.split(" {3}")
    .map(w => w.trim.split(" ").map(MORSE_CODE).mkString)
    .mkString(" ")
}
