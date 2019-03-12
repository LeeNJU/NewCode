package LinkedList;

import Util.ListNode;

//题目描述:给定一个循环链表，已经排好序，但是rotate了一下，向其中插入一个值x，例如3->5->1，插入4，返回5->1->3->4，或者2->2->2插入3，返回3->2->2->2
//解法描述:遍历链表，正确插入的情况有3种，

public class InsertintoaCyclicSortedList {

    public ListNode insert(ListNode node, int x) {
        ListNode newNode = new ListNode(x);

        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }

        ListNode cur = node;
        while (true) {
            // x在两个节点之间
            if (cur.val <= x && cur.next.val >= x) {
                newNode.next = cur.next;
                cur.next = newNode;
                break;
                // 到了最大值和最小值之间的拐点
            } else if (cur.val > cur.next.val && (cur.val <= x || cur.next.val >= x)) {
                newNode.next = cur.next;
                cur.next = newNode;
                break;
                // 处理2->2->2插入3，返回3->2->2->2
            } else if (cur.next == node) {
                newNode.next = cur.next;
                cur.next = newNode;
                break;
            }

            cur = cur.next;
        }

        return newNode;
    }
}
