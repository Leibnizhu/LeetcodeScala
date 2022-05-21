package leetcode.hard.design

import org.scalatest.funsuite.AnyFunSuite

class TrieTest extends AnyFunSuite{
  test("sample"){
    val trie = new Trie
    trie.insert("apple")
    assert(trie.search("apple"))
    assert(!trie.search("app"))
    assert(trie.startsWith("app"))
    trie.insert("app")
    assert(trie.search("app"))
  }
}
