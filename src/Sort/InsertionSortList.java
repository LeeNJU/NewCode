package Sort;

import Util.ListNode;

//题目描述：用插入排序的方法把链表排序
//解法描述：插入排序
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            // 当前元素已经排好序
            if (cur.val >= prev.val) {
                prev = cur;
                cur = cur.next;
                continue;
            }

            ListNode node = dummy;
            while (node.next != prev && node.next.val < cur.val) {
                node = node.next;
            }

            prev.next = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = prev.next;
        }

        return dummy.next;
    }
}
