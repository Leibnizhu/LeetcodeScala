package leetcode.daily

/**
  * 2022-05-13
  * {@see <a href='https://leetcode.cn/problems/one-away-lcci/'/> }
  */
object OneAwayLcci {
  /**
    * 由于是评断是否能一次修改，所以范围可以缩小
    * 几种情况：
    * 1. 长度相同： 逐个字符对比，直接判断不等的字符超过一个就false，否则true（修改一个字符完成）
    * 2. 长度差大于1: 肯定不能一次完成，返回false
    * 3. 长度差1: 需要删一个字符, 逐个字符比较，不同则长的那个字符串跳过，只能跳过一次，否则false
    */
  def oneEditAway(first: String, second: String): Boolean = {
    if (first.length == second.length) {
      var mismatch = false;
      for (i <- 0 until first.length) {
        if (first.charAt(i) != second.charAt(i)) {
          if (mismatch) {
            return false
          } else {
            mismatch = true;
          }
        }
      }
      true
    } else if (Math.abs(first.length - second.length) > 1) {
      false
    } else if (first.length > second.length) { //交换值，保持second更长
      oneEditAway(second, first)
    } else {
      var skip = 0;
      var i = 0;
      while (i < first.length) {
        if (first.charAt(i) != second.charAt(i + skip)) {
          skip += 1
        } else {
          i += 1
        }
        if (skip > 1) {
          return false
        }
      }
      true
    }
  }
}
