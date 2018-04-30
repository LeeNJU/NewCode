package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表，依次交换相邻两个节点，例如1->2->3->4，返回2->1->4->3.
//解法描述:对于当前两个节点进行交换

public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;

        while (cur != null) {
            if (cur.next != null) {
                prev.next = cur.next;
                cur.next = prev.next.next;
                prev.next.next = cur;
                prev = prev.next.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
