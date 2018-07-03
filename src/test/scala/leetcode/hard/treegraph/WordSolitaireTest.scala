package leetcode.hard.treegraph

import org.scalatest.FunSuite

class WordSolitaireTest extends FunSuite {
  /**
    * 输入:
    * beginWord = "hit",
    * endWord = "cog",
    * wordList = ["hot","dot","dog","lot","log","cog"]
    * 输出: 5
    * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    * 返回它的长度 5。
    */
  test("sample1") {
    assert(WordSolitaire.ladderLength("hit", "cog",
      List("hot", "dot", "dog", "lot", "log", "cog")) == 5)
  }

  /**
    * 输入:
    * beginWord = "hit"
    * endWord = "cog"
    * wordList = ["hot","dot","dog","lot","log"]
    * 输出: 0
    * 解释: endWord "cog" 不在字典中，所以无法进行转换。
    */
  test("sample2") {
    assert(WordSolitaire.ladderLength("hit", "cog",
      List("hot", "dot", "dog", "lot", "log")) == 0)
  }

  test("sample3"){
    assert(WordSolitaire.ladderLength("qa", "sq",
      List("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")) == 5)
  }
}
