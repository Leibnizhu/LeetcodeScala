package leetcode.primary.array

/**
  * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
  * 数字 1-9 在每一行只能出现一次。
  * 数字 1-9 在每一列只能出现一次。
  * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
  */
object IsValidSudoku {
  /**
    * 按照规则来就行
    */
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    /**
      * 判断某个字符是否合法
      *
      * @param ch   当前字符
      * @param used 保存那些数字已被使用
      */
    def checkOne(ch: Char, used: Array[Boolean]): Boolean =
      if (ch == '.') true else if (used(ch - '1')) false else {
        used(ch - '1') = true
        true
      }

    /**
      * 判断9个字符是否合法
      *
      * @param chs 9个字符,可能是一行一列或一个3x3方块
      */
    def checkNine(chs: Array[Char]): Boolean = {
      val used: Array[Boolean] = Array.fill(9)(false)
      (true /: chs) ((res, ch) => checkOne(ch, used) && res)
    }

    //检查行
    val lineCheck = (true /: board) ((res, line) => checkNine(line) && res)
    //检查列
    var columnCheck = true
    for (i <- 0 until 9) {
      columnCheck &= checkNine((for {j <- 0 until 9} yield board(j)(i)).toArray)
    }
    //检查3x3
    var boxCheck = true
    for (i <- 0 until 3) {
      for (j <- 0 until 3) {
        //构造方块并检查
        boxCheck &= checkNine((for {
          m <- i * 3 until (i + 1) * 3
          n <- j * 3 until (j + 1) * 3
        } yield board(m)(n)).toArray)
      }
    }

    lineCheck && columnCheck && boxCheck
  }
}
