package LinkedList;

import Util.ListNode;

//题目描述：给定一个链表和一个值k，每k个节点进行一次反转，例如1->2->3->4->5，k=3，返回3->2->1->4->5
//解法描述：用一个哨兵节点，每k个元素进行反转

public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            ListNode cur = head;
            // 判断有没有k个节点
            int count = 0;
            while (cur != null) {
                ++count;
                cur = cur.next;
            }

            if (count < k) {
                break;
            }

            count = k - 1;
            while (count > 0) {
                cur = head.next;
                head.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;

                --count;
            }

            prev = head;
            head = head.next;
        }

        return dummy.next;
    }
}
