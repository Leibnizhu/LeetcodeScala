package leetcode.medium.design

import scala.collection.mutable
import scala.util.Random

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/52/design/110/
  *
  * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
  *  - insert(val)：当元素 val 不存在时，向集合中插入该项。
  *  - remove(val)：元素 val 存在时，从集合中移除该项。
  *  - getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
  */
class RandomizedSet {
  /** Initialize your data structure here. */
  val set = new mutable.HashSet[Int]()
  val rand = new Random()

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  def insert(`val`: Int): Boolean = {
    if (set.contains(`val`))
      false
    else {
      set += `val`
      true
    }
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  def remove(`val`: Int): Boolean = {
    if (!set.contains(`val`))
      false
    else {
      set -= `val`
      true
    }
  }

  /** Get a random element from the set. */
  def getRandom(): Int = {
    val itr = set.iterator
    for (i <- 0 until rand.nextInt(set.size)) itr.next()
    itr.next()
  }
}
