package LinkedList;

import Util.ListNode;

//题目描述:给定两个非空链表，代表两个数字，进行相加，返回结果，例如(2 -> 4 -> 3) + (5 -> 6 -> 4)表示342 + 465， 返回结果7 -> 0 -> 8，表示807
//解法描述:遍历的时候，小技巧：如果是null节点用0表示

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int val = (carry + val1 + val2) % 10;
            node.next = new ListNode(val);
            node = node.next;

            carry = (carry + val1 + val2) / 10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        // 别忘了进位
        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        return dummy.next;
    }

    // 版本2:两个链表相加，(2 -> 4 -> 3) + (5 -> 6 -> 4)表示243 + 564，返回结果8 -> 0 -> 7
    // 先反转链表，再相加
    private ListNode reverseList(ListNode head) {
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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            prev.next = node;
            prev = node;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            prev.next = node;
        }

        return reverseList(dummy.next);
    }
}
