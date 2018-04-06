package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表，判断链表是不是palindrome
//解法描述:利用快慢指针把链表分成两份，反转其中一份，再进行比较，快慢指针遍历之后，快指针指向前一半的最后一个节点，前一半链表的节点数可能比后一半节点数少1（奇数）

public class PalindromeLinkedList {

    private ListNode reverse(ListNode head) {
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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head.next;
        while (slow.next != null && slow.next.next != null) {
            slow = slow.next.next;
            fast = fast.next;
        }

        slow = fast.next;
        fast.next = null;
        slow = reverse(slow);
        fast = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                return false;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }
}
