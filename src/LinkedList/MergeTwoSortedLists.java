package LinkedList;

import Util.ListNode;

//题目描述：给定两个已序链表，将其合并
//解法描述：添加一个哨兵节点，使其指向l1的第一个节点，然后两个指针依次比较大小，注意while循环结束后，要判断哪一个链表为空

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = l1;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev = l1;
                l1 = l1.next;
            } else {
                ListNode node = l2.next;
                l2.next = l1;
                prev.next = l2;
                prev = prev.next;
                l2 = node;
            }
        }

        if (l1 == null) {
            prev.next = l2;
        }

        return dummy.next;
    }
}
