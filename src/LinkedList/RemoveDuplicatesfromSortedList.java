package LinkedList;

import Util.ListNode;

//题目描述:给定一个已排序链表，删除其中的重复元素，使得每个元素只出现一次，例如1->1->2，返回1->2
//解法描述: 遍历，比较当前元素和之前的元素

public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head, cur = head.next;
        while (cur != null) {
            if (cur.val == prev.val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }

    // 题目描述:给定已排序的链表，删除其中的重复元素，例如1->2->3->3->4->4->5，返回1->2->5
    // 解法描述:对于当前节点，判断是否重复，如果是重复的，重复删除

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, prev = dummy;

        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }

                prev.next = cur;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
