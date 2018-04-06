package LinkedList;

import Util.ListNode;

//题目描述:给定两个链表，两个链表有相交的点，找到这个相交的点并返回，如果没有，返回null，例如
//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3     结果返回c1
//                   ↗
//B:     b1 → b2 → b3
//解法描述:找到两个链表的长度差，然后一起移动头指针，直到两个指针指向同一个节点，如果没有相交点，指针最后同时为null

public class IntersectionofTwoLinkedLists {

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            ++length;
        }

        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        int count = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            while (count > 0) {
                headA = headA.next;
                --count;
            }
        } else {
            while (count > 0) {
                headB = headB.next;
                --count;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
