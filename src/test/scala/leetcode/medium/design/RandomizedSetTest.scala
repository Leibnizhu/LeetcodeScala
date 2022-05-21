package leetcode.medium.design

import org.scalatest.funsuite.AnyFunSuite

class RandomizedSetTest extends AnyFunSuite{
  test("sample"){
    // 初始化一个空的集合。
    val set = new RandomizedSet()
    // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
    assert(set.insert(1))
    // 返回 false ，表示集合中不存在 2 。
    assert(!set.remove(2))
    // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
    set.insert(2)
    // getRandom 应随机返回 1 或 2 。
    var rand = set.getRandom()
    assert(rand == 1 || rand == 2)
    rand = set.getRandom()
    assert(rand == 1 || rand == 2)
    rand = set.getRandom()
    assert(rand == 1 || rand == 2)
    // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
    assert(set.remove(1))
    // 2 已在集合中，所以返回 false 。
    assert(!set.insert(2))
    // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
    assert(set.getRandom() == 2)
    assert(set.getRandom() == 2)
    assert(set.getRandom() == 2)
  }
}
