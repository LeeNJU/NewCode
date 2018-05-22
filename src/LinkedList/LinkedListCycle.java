package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表，判断是否有环
//解法描述:两个指针slow和fast，slow每次前进一步，fast每次前进两步，如果二者能够相等，就表示有环

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
