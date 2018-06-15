package leetcode.medium.sortsearch

import org.scalatest.FunSuite

class TopKFrequentElementsTest extends FunSuite {
  test("[1,1,1,2,2,3] k = 2") {
    assert(TopKFrequentElements.topKFrequent(Array(1, 1, 1, 2, 2, 3), 2).sorted == List(1, 2))
  }
}
