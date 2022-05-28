package codewars.kyu5

import scala.collection.mutable
import scala.util.Try

/**
  * 2022-05-28
  * {@see <a href='https://www.codewars.com/kata/58e24788e24ddee28e000053/train/scala'/> }
  */
object SimpleAssemblerInterpreter {
  def interpret(program: List[String]): Map[String, Int] = {
    val ctx = new mutable.HashMap[String, Int]()
    var ptr = 0
    while (ptr < program.size) {
      val command = program(ptr).split(" ")
      command match {
        case Array("mov", x, y) => ctx(x) = Try(y.toInt).getOrElse(ctx(y))
        case Array("inc", x) => ctx(x) = ctx(x) + 1
        case Array("dec", x) => ctx(x) = ctx(x) - 1
        case Array("jnz", x, y) => if (Try(x.toInt).getOrElse(ctx(x)) != 0) ptr += (y.toInt - 1)
      }
      ptr += 1
    }
    ctx.toMap
  }
}
