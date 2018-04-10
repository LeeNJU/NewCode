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
}
