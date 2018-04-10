package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表和一个元素x，分割链表，使得元素比x小的在前面，大于等于x的元素在后面，例如1->4->3->2->5->2，x = 3，返回1->2->2->4->3->5
//解法描述:dummy node,遍历

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode great = new ListNode(0);
        ListNode great_prev = great;
        ListNode small = new ListNode(0);
        ListNode small_prev = small;

        while (head != null) {
            if (head.val < x) {
                great_prev.next = head;
                great_prev = head;
                head = head.next;
                great_prev.next = null;
            } else {
                small_prev.next = head;
                small_prev = head;
                head = head.next;
                small_prev.next = null;
            }
        }

        great_prev.next = small.next;
        return great.next;
    }

}
