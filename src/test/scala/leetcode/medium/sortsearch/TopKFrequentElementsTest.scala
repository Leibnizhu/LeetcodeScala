package leetcode.medium.sortsearch

import org.scalatest.funsuite.AnyFunSuite

class TopKFrequentElementsTest extends AnyFunSuite {
  test("[1,1,1,2,2,3] k = 2") {
    assert(TopKFrequentElements.topKFrequent(Array(1, 1, 1, 2, 2, 3), 2).sorted == List(1, 2))
  }
}
