package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表，将下标为奇数的放到前面，下标为偶数的放到后面，例如1->2->3->4->5->NULL, 返回1->3->5->2->4->NULL
//解法描述:dummy node

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode even = new ListNode(0);
        ListNode even_prev = even;
        ListNode odd = new ListNode(0);
        ListNode odd_prev = odd;

        while (head != null) {
            odd_prev.next = head;
            odd_prev = odd_prev.next;
            head = head.next;
            odd_prev.next = null;

            if (head != null) {
                even_prev.next = head;
                even_prev = even_prev.next;
                head = head.next;
                even_prev.next = null;
            }
        }

        odd_prev.next = even.next;
        return odd.next;
    }

}
