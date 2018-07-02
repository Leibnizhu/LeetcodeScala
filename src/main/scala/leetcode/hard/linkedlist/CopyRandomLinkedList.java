package leetcode.hard.linkedlist;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/56/linked-list/136/
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深度拷贝。
 */
public class CopyRandomLinkedList {
    /**
     * 考虑到深拷贝除了值和next还需要保留random的指针
     * 而新链表里面random要指向谁,只有在新链表建立后才知道新的节点.
     * 所以复制的时候要保留原节点的random指针,而且需要遍历两次
     * 第一次需要复制值,并建立next关联,第二次根据旧的random指针去设置新的random指针
     * 为了能在第二次遍历的时候,拿到旧的random指针,可以在第一次遍历复制的时候,将旧节点指向对应新节点,新节点指向旧节点的next
     * 构成一个两倍长度的链表,这样在第二次遍历的时候,遍历旧的头,两倍速度,就可以拿到新节点对应的新random指针
     * 设置完新的random指针之后,就可以最后遍历一次,拆分新旧链表了
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        /*
         * 复制值,如前面注释所述,举例 1->2->3->4 执行后变成:
         * 旧head= 1   2   3   4
         *        | / | / | / |
         *        1   2   3   4
         */
        for (RandomListNode p = head; p != null; ) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        //对新链表的random赋值
        for (RandomListNode p = head; p != null; ) {
            if (p.random != null)
                p.next.random = p.random.next; //所有旧节点的next都指向对应的新节点
            p = p.next.next;
        }
        //拆分新旧链表
        RandomListNode dummy = new RandomListNode(-1);
        for (RandomListNode pOld = head, pNew = dummy; pOld != null;) {
            pNew.next = pOld.next;
            pNew = pNew.next;
            pOld.next = pOld.next.next; //旧链表要维持原来的链接,所以这里要分两步,第一步先恢复next指针,而不能直接 pOld = pOld.next.next
            pOld = pOld.next;
        }
        return dummy.next;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
