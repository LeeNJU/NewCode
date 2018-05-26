package LinkedList;

import Util.ListNode;

//题目描述：给链表排序，要求复杂度为nlog(n)
//解法描述：归并排序

public class SortList {

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;

        ListNode prev = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev = list1;
                list1 = list1.next;
            } else {
                ListNode node = list2.next;
                list2.next = list1;
                prev.next = list2;
                prev = list2;
                list2 = node;
            }
        }

        if (list1 == null) {
            prev.next = list2;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        slow = sortList(slow);
        head = sortList(head);

        return merge(head, slow);
    }
}
