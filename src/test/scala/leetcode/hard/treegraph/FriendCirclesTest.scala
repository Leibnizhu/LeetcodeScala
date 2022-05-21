package leetcode.hard.treegraph

import org.scalatest.funsuite.AnyFunSuite

class FriendCirclesTest extends AnyFunSuite {
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
    * [[1,1,0],(
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

  test("print") {
    println(printNums(4))
    println(printNums(6))
    println(printNums(10))
  }

  def printNums(n: Int): List[String] = {
    def next(result: List[String], queue: List[String]): List[String] = queue match {
      case q if q.isEmpty => result //队列空,找完
      case q if q.head.length == n => next(result :+ queue.head, queue.tail) //当前字符串算完,加入结果集
      case q => //普通情况,往队列添加两个下一步的字符串
        val curStr = q.head
        val curNum = curStr.last - '0'
        next(result, q.tail ++ List(curStr + curNum, curStr + (curNum + 1)))
    }

    next(List[String](), List("0"))
  }
}
