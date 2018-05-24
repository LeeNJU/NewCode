package LinkedList;

import Util.ListNode;

//题目描述:反转链表
//解法描述:反转链表

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head.next;
        while (cur != null) {
            head.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = head.next;
        }

        return dummy.next;
    }
}
