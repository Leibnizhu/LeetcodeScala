package leetcode.hard.treegraph

import org.scalatest.FunSuite

class FriendCirclesTest extends FunSuite {
  /**
    * 输入:
    * [[1,1,0],
    *  [1,1,0],
    * [0,0,1]]
    * 输出: 2
    * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
    * 第2个学生自己在一个朋友圈。所以返回2。
    */
  test("sample1") {
    assert(FriendCircles.findCircleNum(Array(
      Array(1, 1, 0),
      Array(1, 1, 0),
      Array(0, 0, 1)
    )) == 2)
  }

  /**
    * 输入:
    * [[1,1,0],
    *  [1,1,1],
    * [0,1,1]]
    * 输出: 1
    * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
    */
  test("sample2") {
    assert(FriendCircles.findCircleNum(Array(
      Array(1, 1, 0),
      Array(1, 1, 1),
      Array(0, 1, 1)
    )) == 1)
  }
}
