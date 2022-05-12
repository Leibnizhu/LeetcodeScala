package leetcode.daily

/**
  * {@see <a href='https://leetcode.cn/problems/delete-columns-to-make-sorted/'/> }
  */
object DeleteColumnsToMakeSorted {
  def minDeletionSize(strs: Array[String]): Int = {
    def calRow(strs: Array[String], row: Int): Int = {
      for (i <- 1 until strs.length) {
        if (strs(i).charAt(row) < strs(i - 1).charAt(row)) {
          return 1
        }
      }
      0
    }

    if (strs.isEmpty || strs.length == 1 || strs(0).isEmpty) {
      0
    } else {
      (0 until strs(0).length).map(calRow(strs, _)).sum
    }
  }
}
