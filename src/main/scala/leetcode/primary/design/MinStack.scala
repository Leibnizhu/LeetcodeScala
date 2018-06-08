package leetcode.primary.design

import java.util

class MinStack {

  /** initialize your data structure here. */
  val stack = new util.Stack[Int]() //保存push进来的数据
  val minStack = new util.Stack[Int]() //维护当前栈顶的最小值,push stack的时候同时push min(栈顶,当前值)

  def push(x: Int) {
    stack.push(x)
    minStack.push(if(minStack.isEmpty) x else Math.min(minStack.peek(), x))
  }

  def pop() {
    stack.pop()
    minStack.pop()
  }

  def top(): Int = {
    stack.peek()
  }

  def getMin(): Int = {
    minStack.peek()
  }
}
