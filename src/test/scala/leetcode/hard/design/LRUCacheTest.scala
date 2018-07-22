package leetcode.hard.design

import org.scalatest.FunSuite

class LRUCacheTest extends FunSuite {
  test("sample1") {
    var cache = new LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    assert(cache.get(1) == 1) // 返回  1
    cache.put(3, 3) // 该操作会使得密钥 2 作废
    assert(cache.get(2) == -1) // 返回 -1 (未找到)
    cache.put(4, 4) // 该操作会使得密钥 1 作废
    cache.get(1)
    assert(cache.get(3) == 3) // 返回  3
    assert(cache.get(4) == 4) // 返回  4
  }
}
