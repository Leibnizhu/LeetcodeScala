package leetcode.hard.backtracking

import leetcode.hard.design.Trie

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/147/
  *
  * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
  * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
  * 说明:
  *  - 你可以假设所有输入都由小写字母 a-z 组成。
  * 提示:
  *  - 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
  *  - 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
  */
object WordSearchII {
  /**
    * 提示很明显了,如果遍历words,用原来的DFS直接搜,会超时,要按提示用Trie
    * 为此先去做了"设计问题"部分的前缀树实现leetcode.hard.design.Trie,这里直接import了
    * 先用words构造一个前缀树,然后DFS搜board,判断当前路径如果不在任何单词的前缀则立刻返回,减少计算量
    */
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    /**
      * 深度优先搜索
      *
      * @param board   地图
      * @param trie    要查找的单词构成的前缀树
      * @param visited 当前有效已读过的地图
      * @param result  搜索结果
      * @param word    当前搜索路径拼成的单词
      * @param x       当前读取的地图x坐标, 对应高
      * @param y       当前读取的地图y坐标, 对应宽
      * @return
      */
    def dfs(board: Array[Array[Char]], trie: Trie, visited: Array[Array[Boolean]])
           (result: Set[String], word: String)(x: Int, y: Int): Set[String] = {
      if (x < 0 || x >= board.length || y < 0 || y >= board(0).length) //越界
        result
      else if (visited(x)(y)) // 已经查过,剪枝
        result
      else {
        val newWord = word + board(x)(y) //当前搜索路径的单词
        if (!trie.startsWith(newWord)) //不相等,剪枝,要在这里提前计算新路径并剪枝,减少计算量
          result
        else { // 当前路径拼接的前缀在前缀树中存在,继续查下一个
          var curRes = result
          if (trie.search(newWord)) curRes += newWord //已查找到,但可能还有同前缀的,因此要继续找
          visited(x)(y) = true
          //向四个方向查找
          curRes = dfs(board, trie, visited)(curRes, newWord)(x - 1, y)
          curRes = dfs(board, trie, visited)(curRes, newWord)(x + 1, y)
          curRes = dfs(board, trie, visited)(curRes, newWord)(x, y - 1)
          curRes = dfs(board, trie, visited)(curRes, newWord)(x, y + 1)
          visited(x)(y) = false //当前节点失败,不能进一步匹配,要在visited中去掉,避免其他节点查找到的时候跳过
          curRes
        }
      }
    }

    val trie = new Trie
    words.foreach(trie.insert) //构造前缀树
    val h = board.length //高
    val w = board(0).length //宽
    val visited = Array.ofDim[Boolean](h, w) //记录每个点是否读过
    var result = Set[String]()
    for { //遍历每一个点,分别去深度优先搜索(当然,有visited帮忙剪枝)
      i <- 0 until h
      j <- 0 until w
    } yield result = dfs(board, trie, visited)(result, "")(i, j) //找到了直接返回
    result.toList
  }
}
