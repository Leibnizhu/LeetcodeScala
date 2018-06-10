package leetcode.medium.arraystring

import org.scalatest.FunSuite

class GroupAnagramsTest extends FunSuite{
  test("eat, tea, tan, ate, nat, bat"){
    val result = GroupAnagrams.groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat"))
    assert(result.length == 3)
    assert(result.head == List("bat"))
    assert(result(1).sorted == List("ate","eat","tea").sorted)
    assert(result(2).sorted == List("nat","tan").sorted)
  }
}
