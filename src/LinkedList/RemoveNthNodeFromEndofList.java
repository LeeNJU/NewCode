package LinkedList;

import Util.ListNode;

//题目描述：给定一个链表，要求删除倒数第n个元素
//解法描述：添加一个哨兵节点，求出链表长度，把指针移动到要删除的元素的前一个元素，进行删除

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        while (head != null) {
            head = head.next;
            ++length;
        }

        n = length - n;
        ListNode cur = dummy;
        while (n > 0) {
            --n;
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }
}
