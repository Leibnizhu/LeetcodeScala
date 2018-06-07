package leetcode.primary.linkedlist;

import java.util.Objects;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
 *
 * 给定一个链表，判断链表中是否有环。
 * 进阶：你能否不使用额外空间解决此题？
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
//        System.out.println(fast == null ? "null" : fast.x+","+slow.x);
        return fast == slow;
    }

    public static class ListNode {
        int x;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return x == listNode.x &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, next);
        }

        ListNode(int x) {
            this.x = x;
        }
    }
}
