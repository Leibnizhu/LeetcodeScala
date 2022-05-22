package leetcode.daily


/**
  * 2022-05-22
  * {@see <a href='https://leetcode.cn/problems/can-i-win/'/> }
  */
object CanIWin {
  def canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean = {
    //定义局面为： maxChoosableInteger 位bit ，1=使用，0=未使用, 第i位对应数字  i+1
    // 使用一个数字 num 为 case | (1<<(num-1))
    val mustWin = new scala.collection.mutable.HashMap[Int, Boolean]() //某个局面接下来先手是否必胜

    def dfs(curCase: Int, totalLeft: Int): Boolean = {
      if (mustWin.contains(curCase)) {
        mustWin(curCase)
      } else {
        for (num <- maxChoosableInteger to 1 by -1) { //优先选大的
          val caseNum = 1 << (num - 1)
          if ((curCase & caseNum) == 0) { //当前数字没用过
            if (num >= totalLeft || !dfs(curCase | caseNum, totalLeft - num)) {
              //当前可选最大的数选了直接赢，那么必赢；要么就看接下来是否必赢
              mustWin(curCase) = true
              return true
            }
          }
        }
        mustWin(curCase) = false
        false
      }
    }

    val sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2
    if (maxChoosableInteger >= desiredTotal) {
      true //先出手的直接选择 >= desiredTotal 的数，可以稳赢
    } else if (sum < desiredTotal) {
      false //目前所有可选的数加起来都不如剩余目标数字大，那么双方都不可能获胜
    } else if (sum == desiredTotal) {
      maxChoosableInteger % 2 == 1 //最后一个拿到数字的人获胜，所以总回合数是奇数的时候先手获胜
    } else { //其余情况dfs搜索
      dfs(0, desiredTotal)
    }
  }
}
