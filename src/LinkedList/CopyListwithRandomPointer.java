package LinkedList;

import Util.RandomListNode;

//题目描述：给定一个链表，每个节点都包含一个randome指针，指向链表中的某一个元素或者为null，现在完成该链表的深拷贝
//解法描述：构建一个新的节点，就把该节点插入到对应原节点的后面，再逐一复制randome指针的值，最后把链表分开成2个链表，例如原链表为1->2, 插入后为1->1->2->2,然后在分开
public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        // 创建新的节点，把新的节点插入到对应原节点的后面
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode randomListNode = new RandomListNode(cur.label);
            randomListNode.next = cur.next;
            cur.next = randomListNode;
            cur = cur.next.next;
        }

        // 复制每个节点的random指针
        cur = head;
        while (cur != null) {
            // 注意是cur->randome->next
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        // 分割两个链表
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        cur = head;
        while (cur != null) {
            prev.next = cur.next;
            prev = prev.next;

            cur.next = cur.next.next;
            prev.next = null;
            cur = cur.next;
        }

        return dummy.next;
    }
}
