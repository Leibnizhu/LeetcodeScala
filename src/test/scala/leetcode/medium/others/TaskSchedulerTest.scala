package leetcode.medium.others

import org.scalatest.FunSuite

class TaskSchedulerTest extends FunSuite {
  test("[A,A,A,B,B,B], n = 2") {
    assert(TaskScheduler.leastInterval("AAABBB".toCharArray, 2) == 8)
  }

  test("[A,B,C,D,E,A,F,G,H,A,I,B,J,K,L], n=3"){
    assert(TaskScheduler.leastInterval("ABCDEAFGHAIBJKL".toCharArray, 3) == 15)
  }
}
