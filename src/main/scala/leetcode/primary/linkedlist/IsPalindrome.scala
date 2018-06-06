package leetcode.primary.linkedlist

/**
  * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/45/
  * 请判断一个链表是否为回文链表。
  * 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
  */
object IsPalindrome {
  /**
    * 1.两个游标,一个一次走一步一个一次走2步,
    * 2.快游标到尾部之后,慢游标应该在中间,此时把后面的链表翻转
    * 3.比较两个半长度的链表
    *
    * @param head 链表头
    * @return 是否回文链表
    */
  def isPalindrome(head: ListNode): Boolean = {
    if(head == null){
      true
    } else {
      val middle = findMiddle(head) // 该节点为头的链表需要翻转
      val newAfterMiddle = reverseListRecursive(null, middle.next)//翻转,返回翻转后的新头
      //设置前后两个游标同步跑,判断是否相同
      var front = newAfterMiddle
      var back = head
      while(front != null && back != null && front.x == back.x){ //直到跑到队尾,或者两者不一样
        front = front.next
        back = back.next
      }
      front == null //如果是前面的游标跑到队尾而导致结束的,那么就是两边一直相同,是回文链表
    }
  }

  /**
    * 快慢游标实现
    *
    * @param head 链表头
    * @return 中心节点(链表长度为奇数则正中间的,链表长度为偶数则中间两个之中偏前的,保证返回值节点(不包含)后面的链表是需要翻转的)
    */
  def findMiddle(head:ListNode):ListNode = {
    if(head == null){
      null
    } else {
      var slow = head
      var fast = head.next
      // 快指针没到队尾,两种情况(画图可知):
      // 1.长度奇数,快游标跑到null去了,慢游标在正中间
      // 2.偶数长度,快游标到队尾去了,慢游标在中间偏前面的节点
      while(fast != null && fast.next != null){
        slow = slow.next
        fast = fast.next.next
      }
      slow
    }
  }

  /**
    * 递归调用翻转链表
    * 链表分为head::tail,递归调用reverseList翻转tail, 再把head和tail的关系倒转
    *
    * 注:这个题目会给一个超大的链表做测试,而这个递归原来不是尾递归(ReverseList),所以会堆栈溢出,因此这里要改成尾递归
    *
    * @return 翻转后的头结点
    */
  def reverseListRecursive(first: ListNode, second:ListNode): ListNode = {
    if (second == null) {
      //空表或单节点表
      first
    } else {
      val secondBeforeNext = second.next
      second.next = first
      reverseListRecursive(second, secondBeforeNext) //递归翻转tail链表
    }
  }
}
