package codewars.kyu1

import scala.collection.mutable.ArrayBuffer

/**
  * 2022-06-20
  * {@see <a href='https://www.codewars.com/kata/5993c1d917bc97d05d000068/train/scala'/> }
  */
object RegularExpressionForBinaryNumbersDivisibleByN {

  case class DFA(private val stateNum: Int) {
    case class Arc(edge: (Int, Int), regexString: String)

    case class State(index: Int, preList: ArrayBuffer[Int], postList: ArrayBuffer[Int])

    val arcs: ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer.fill(stateNum, stateNum)("")
    val states: ArrayBuffer[State] = ArrayBuffer.empty[State]

    def addArc(from: Int, to: Int, str: String): Unit = {
      if (from != to) {
        states(from).postList += to
        states(to).preList += from
      }
      arcs(from)(to) = str
    }

    def init(): Unit = {
      for (index <- 0 until stateNum) {
        states += State(index, ArrayBuffer.empty[Int], ArrayBuffer.empty[Int])
      }

      for (index <- 0 until stateNum) {
        addArc(index, (index * 2) % stateNum, "0")
        addArc(index, (index * 2 + 1) % stateNum, "1")
      }
    }

    def deleteArc(state: State, pre: Boolean, index: Int): Unit = {
      val list = if (pre) state.preList else state.postList
      val i = list.indexOf(index)
      if (i > 0) list.remove(i, 1)
    }

    /**
      * 当消除状态s时，自动机中所有经过s的状态都不存在了
      * 可以把与s相关的状态划分成三类
      * 1.假设 q1,q2,...,qn是s的前驱状态,记作集合Q
      * 2.p1, p2, ..., pm 是s的后继状态，记作集合P
      * 3. S是从s到s的环，且S∩Q = S∩P = empty
      * 当删除状态s时删除了所有涉及状态s的边，作为补偿，需要给p_i,q_j集合中引入新的正则表达式
      * {q_j}S*{p_i} 新边 Arc(q_j, p_i, {q_j}S*{p_i})
      * 该正则表达式需要与状态q_j -> p_i 上原有的表达式r_ij合并（如果没有，就设原来的表达式为空集)
      *
      * @param s 需要被消除的状态
      * @return 消除s状态后的DFA
      */
    def reduceState(s: Int): DFA = {

      val state = states(s)

      for (qi <- state.preList; pi <- state.postList) {
        val q = states(qi)
        val p = states(pi)
        val Rpq = arcs(qi)(pi)
        val qArc = arcs(qi)(state.index)
        val pArc = arcs(state.index)(pi)
        val sArc = arcs(state.index)(state.index)

        val S = sArc.length match {
          case 0 => ""
          case 1 => s"$sArc*"
          case _ => s"($sArc)*"
        }

        def genStr(s: String): String = if (s.contains("|")) s"($s)" else s

        val Q = genStr(qArc)
        val P = genStr(pArc)

        val str = if (Rpq.length > 0) Array(genStr(Rpq), Q + S + P).mkString("|") else Q + S + P
        deleteArc(q, pre = false, p.index)
        deleteArc(p, pre = true, q.index)
        addArc(q.index, p.index, str)
        deleteArc(q, pre = false, state.index)
        deleteArc(p, pre = true, state.index)
      }
      this
    }

    def finalState: String = {
      s"^(${arcs(0)(0)})+" + "$"
    }
  }

  def regexDivisibleBy(n: Int): String = {
    if (n == 1) return s"(0|1)*"
    val m = DFA(n)
    m.init()
    val res = (1 until n).foldLeft(m)((dfa, state) => dfa.reduceState(state))
    res.finalState
  }
}
