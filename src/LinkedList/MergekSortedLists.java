package LinkedList;

import Util.ListNode;

//题目描述:合并k个有序的链表
//解法描述:归并排序的思想

public class MergekSortedLists {

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode prev = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev = list1;
                list1 = list1.next;
            } else {
                ListNode node = list2.next;
                list2.next = list1;
                prev.next = list2;
                prev = prev.next;
                list2 = node;
            }
        }

        if (list1 == null) {
            prev.next = list2;
        }

        return dummy.next;
    }

    private ListNode mergeKLists(ListNode[] lists, int p, int q) {
        if (p == q) {
            return lists[p];
        } else if (p < q) {
            int middle = p + (q - p) / 2;
            ListNode list1 = mergeKLists(lists, p, middle);
            ListNode list2 = mergeKLists(lists, middle + 1, q);
            return mergeLists(list1, list2);
        } else {
            return null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }
}
