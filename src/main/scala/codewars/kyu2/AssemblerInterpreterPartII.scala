package codewars.kyu2

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Try

/**
  * 2022-06-15
  * {@see <a href='https://www.codewars.com/kata/58e61f3d8ff24f774400002c/train/scala'/> }
  */
object AssemblerInterpreterPartII {
  case class Command(command: String, args: Array[String])

  def parseMsg(msg: String): Array[String] = {
    val curSegment = new mutable.StringBuilder()
    val args = new ListBuffer[String]
    var inString = false
    for (c <- msg.toCharArray) {
      if (c.isSpaceChar) {
        if (inString) curSegment.addOne(c)
      } else if (c == '\'') {
        inString = !inString
        curSegment.addOne(c)
      } else if (c == ',') {
        if (inString) curSegment.addOne(c) else {
          args += curSegment.toString()
          curSegment.clear()
        }
      } else {
        curSegment.addOne(c)
      }
    }
    if (curSegment.nonEmpty) {
      args += curSegment.toString()
    }
    args.toArray
  }

  def interpret(input: String): Option[String] = {
    val commands = input.split("\n").map(r => r.replaceAll(";.+$", "").trim).filter(_.nonEmpty) //去注释，过滤空行
      .map(r => r.split("\\s+", 2) match {
        case Array(command) => Command(command, null)
        case Array("msg", msg) => Command("msg", parseMsg(msg))
        case Array(command, args) => Command(command, args.split(",\\s*"))
      })
    val labels = commands.zipWithIndex.filter(t => t._1.command.endsWith(":")).map(t => (t._1.command.stripSuffix(":"), t._2)).toMap //标签=>行数
    val ctx = new scala.collection.mutable.HashMap[String, Int]()

    def getVal(param: String): Int = Try(param.toInt).getOrElse(ctx(param))

    var (ptr, lastResult, callStack, funcMsg) = (0, 0, List[Int](), null.asInstanceOf[String])
    var msg: Option[String] = None
    while (ptr < commands.length) {
      commands(ptr) match {
        case Command("mov", Array(x, y)) => ctx(x) = getVal(y) //copy y (either an integer or the value of a register) into register x.
        case Command("inc", Array(x)) => ctx(x) += 1 //increase the content of register x by one.
        case Command("dec", Array(x)) => ctx(x) -= 1 //decrease the content of register x by one.
        case Command("add", Array(x, y)) => ctx(x) += getVal(y) //add the content of the register x with y (either an integer or the value of a register) and stores the result in x (i.e. register[x] += y).
        case Command("sub", Array(x, y)) => ctx(x) -= getVal(y) //subtract y (either an integer or the value of a register) from the register x and stores the result in x (i.e. register[x] -= y).
        case Command("mul", Array(x, y)) => ctx(x) *= getVal(y) //same with multiply (i.e. register[x] *= y).
        case Command("div", Array(x, y)) => ctx(x) /= getVal(y) //same with integer division (i.e. register[x] /= y).
        case Command(c, _) if c.endsWith(":") => println(s"Defined label $c at line $ptr") //define a label position (label = identifier + ":", an identifier being a string that does not match any other command). Jump commands and call are aimed to these labels positions in the program.
        case Command("jmp", Array(label)) => ptr = labels(label) //jumps to the label lbl.
        case Command("cmp", Array(x, y)) => lastResult = getVal(x) - getVal(y) //compares x (either an integer or the value of a register) and y (either an integer or the value of a register). The result is used in the conditional jumps (jne, je, jge, jg, jle and jl)
        case Command("jne", Array(label)) => if (lastResult != 0) ptr = labels(label) //jump to the label lbl if the values of the previous cmp command were not equal.
        case Command("je", Array(label)) => if (lastResult == 0) ptr = labels(label) //jump to the label lbl if the values of the previous cmp command were equal.
        case Command("jge", Array(label)) => if (lastResult >= 0) ptr = labels(label) //jump to the label lbl if x was greater or equal than y in the previous cmp command.
        case Command("jg", Array(label)) => if (lastResult > 0) ptr = labels(label) //jump to the label lbl if x was greater than y in the previous cmp command.
        case Command("jle", Array(label)) => if (lastResult <= 0) ptr = labels(label) //jump to the label lbl if x was less or equal than y in the previous cmp command.
        case Command("jl", Array(label)) => if (lastResult < 0) ptr = labels(label) //jump to the label lbl if x was less than y in the previous cmp command.
        case Command("call", Array(label)) => { //call to the subroutine identified by lbl. When a ret is found in a subroutine, the instruction pointer should return to the instruction next to this call command.
          callStack ::= ptr
          ptr = labels(label)
          funcMsg = null
        }
        case Command("ret", _) => { //when a ret is found in a subroutine, the instruction pointer should return to the instruction that called the current function.
          ptr = callStack.head
          callStack = callStack.tail
          if (funcMsg != null) msg = Option(funcMsg)
        }
        case Command("msg", args) => { //this instruction stores the output of the program. It may contain text strings (delimited by single quotes) and registers. The number of arguments isn't limited and will vary, depending on the program.
          funcMsg = args.map(arg => if (arg.startsWith("'")) arg.stripPrefix("'").stripSuffix("'") else ctx(arg)).mkString
          if (callStack.isEmpty) msg = Option(funcMsg)
        }
        case Command("end", _) => ptr = commands.length //this instruction indicates that the program ends correctly, so the stored output is returned (if the program terminates without this instruction it should return the default output: see below).
      }
      ptr += 1
    }
    println(s"==>input: $input, result: $msg")
    println("====================")
    msg
  }
}