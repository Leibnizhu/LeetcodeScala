package leetcode.hard.treegraph

import org.scalatest.funsuite.AnyFunSuite

class CourseScheduleIITest extends AnyFunSuite {
  test("2, [[1,0]]") {
    assert(CourseScheduleII.findOrder(2, Array(Array(1, 0))) sameElements Array(0, 1))
  }

  test("4, [[1,0],[2,0],[3,1],[3,2]]") {
    val result = CourseScheduleII.findOrder(4, Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2)))
    assert(result.sameElements(Array(0, 1, 2, 3)) || result.sameElements(Array(0, 2, 1, 3)))
  }

  test("2, [[1,0],[0,1]]") {
    assert(CourseScheduleII.findOrder(2, Array(Array(1, 0), Array(0, 1))).isEmpty)
  }

  test("3, [[0,1],[2,1],[0,2]]") {
    assert(CourseScheduleII.findOrder(3, Array(Array(0, 1), Array(2, 0), Array(1, 2))).isEmpty)
  }
}
