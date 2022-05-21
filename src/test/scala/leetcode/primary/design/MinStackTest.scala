package leetcode.primary.design

import org.scalatest.funsuite.AnyFunSuite

class MinStackTest extends AnyFunSuite {

  /**
    * 官方例子
    */
  test("sample") {
    val minStack = new MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    assert(minStack.getMin() == -3)
    minStack.pop()
    assert(minStack.top() == 0)
    assert(minStack.getMin() == -2)
  }
}
