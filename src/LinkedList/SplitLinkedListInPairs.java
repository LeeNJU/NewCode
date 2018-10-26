package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表和一个k值，把链表尽量均分成k块，每块长度不超过1，例如root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3，最后返回
//        [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解法描述:主要是计算每个部分的长度，然后依次遍历

public class SplitLinkedListInPairs {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            ++length;
        }

        ListNode[] result = new ListNode[k];
        int index = 0;
        cur = root;
        while (cur != null) {
            // 计算每个部分的长度，要考虑除不尽的情况
            int count = length / k;
            if (count == 0 || length % k != 0) {
                ++count;
            }

            // 要更新链表的总长度和k
            length -= count;
            --k;

            result[index++] = cur;
            while (count > 1) {
                cur = cur.next;
                --count;
            }

            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return result;
    }
}
