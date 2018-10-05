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

    // 题目描述:给定一个链表，如果链表有环，则返回环的起始位置，否则返回null
    // 解法描述:两个指针ptr1和ptr2都指向head，ptr1走一步，ptr2走2步，二者重合的时候，让ptr1指向head，然后二者同时
    // 每次向后走一步，直到二者再次重合，即为解
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
