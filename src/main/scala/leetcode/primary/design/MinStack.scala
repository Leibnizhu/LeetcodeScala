package leetcode.primary.design

import java.util

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/59/
  *
  * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
  *
  * push(x) -- 将元素 x 推入栈中。
  * pop() -- 删除栈顶的元素。
  * top() -- 获取栈顶元素。
  * getMin() -- 检索栈中的最小元素。
  */
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
