package leetcode.hard.treegraph

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/137/
  *
  * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
  * 每次转换只能改变一个字母。
  * 转换过程中的中间单词必须是字典中的单词。
  * 说明:
  *  - 如果不存在这样的转换序列，返回 0。
  *  - 所有单词具有相同的长度。
  *  - 所有单词只由小写字母组成。
  *  - 字典中不存在重复的单词。
  *  - 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
  */
object WordSolitaire {
  /**
    * 因为要找最短路径,使用广度优先搜索BFS
    */
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    case class State(word: String)(val level: Int) //记录状态,level为第几级(不参与hash和equals),方便得到结果
    val len = beginWord.length //所有单词的统一长度

    /**
      * 跳过下标skip的字符,从begin下标开始,比较两个字符串是否相等
      */
    def skipEqual(src: String, target: String, skip: Int, begin: Int): Boolean = begin match {
      case `len` => true //到达最后一步
      case i if i == skip || src.charAt(i) == target.charAt(i) =>
        skipEqual(src, target, skip, begin + 1) //当前下标需要跳过,或对应字符相等
      case _ => false //对应下标的字符不相等
    }

    /**
      * 查找cur状态的所有可用下一个状态/步骤
      */
    def nextStates(cur: State, visited: Set[State]): Set[State] = (0 until len)
      .flatMap(i => wordList //遍历每一个字符,在wordList找有没有可以转换的单词
        .filter(w => skipEqual(cur.word, w, i, 0) && w != cur.word) //满足转换规则,且跳过当前单词
        .map(State(_)(cur.level + 1))
        .filter(!visited.contains(_)) //排除已经处理和待处理的
      ).toSet

    /**
      * 广度优先搜索
      * wordList所有元素最多进一次queue(不一定会出,如果提前找到答案了),都会进去visited
      * 因此时间和空间复杂度都是O(n)
      *
      * @param queue   待处理的State队列
      * @param visited 已处理(包含待处理)的State集合
      * @return 搜索到的深度
      */
    def bfs(queue: List[State], visited: Set[State]): Int =
      if (queue.isEmpty) {
        0 //队列为空还没找到正确答案(如果找到应该在前面步骤就返回了),则没有解答,返回0
      } else {
        val curState = queue.head
        if (curState.word == endWord) {
          curState.level + 1 //找到目标单词,返回当前级别,根据题目定义,需要+1
        } else {
          val next = nextStates(curState, visited) //查找下一步可用的State
          bfs(queue.tail ++ next, visited ++ next) //待处理队列要去掉当前State
        }
      }

    val beginState = State(beginWord)(0) //从beginWord开始搜索
    bfs(List(beginState), Set(beginState))
  }
}
