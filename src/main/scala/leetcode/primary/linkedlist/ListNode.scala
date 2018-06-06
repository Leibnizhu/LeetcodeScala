package leetcode.primary.linkedlist

case class ListNode(var x: Int, var next: ListNode)
object ListNode {
  def makeLinkedList(nodes: Array[Int], len: Int, cycle: Boolean = false): ListNode = {
    if (len == 0) {
      null
    } else {
      val nodeList = new Array[ListNode](len)
      nodeList(len - 1) = ListNode(nodes.last, null)
      for (i <- len - 2 to 0 by -1) {
        nodeList(i) = ListNode(nodes(i), nodeList(i + 1))
      }
      if (cycle) nodeList(len - 1).next = nodeList(0)
      nodeList(0)
    }
  }

  def linkedListToArray(newList: ListNode, len: Int): Array[Int] = {
    var cur = newList
    val result = new Array[Int](len)
    var i = 0
    while (cur != null) {
      result(i) = cur.x
      i += 1
      cur = cur.next
    }
    result
  }
}
