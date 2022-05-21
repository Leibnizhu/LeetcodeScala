package leetcode.medium.arraystring

import org.scalatest.funsuite.AnyFunSuite

class GroupAnagramsTest extends AnyFunSuite {
  test("eat, tea, tan, ate, nat, bat"){
    val result = GroupAnagrams.groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat"))
    print(result)
    assert(result.length == 3)
    val sortedResult = result.sortBy(r => r.length)
    assert(sortedResult.head == List("bat"))
    assert(sortedResult(1).sorted == List("nat","tan").sorted)
    assert(sortedResult(2).sorted == List("ate","eat","tea").sorted)
  }
}
