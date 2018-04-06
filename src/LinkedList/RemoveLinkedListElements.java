package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表和一个元素val，删除链表中和该元素相等的节点，例如1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6，最后得到1 --> 2 --> 3 --> 4 --> 5
//解法描述:加一个dummy节点

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                prev.next = head;
            } else {
                prev = head;
                head = head.next;
            }
        }

        return dummy.next;
    }
}
