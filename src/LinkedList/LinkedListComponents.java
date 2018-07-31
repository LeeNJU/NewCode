package LinkedList;

import java.util.HashSet;
import java.util.Set;

import Util.ListNode;

//题目描述:给定一个链表和一个链表的子集元素，找到链表中的connected component，例如给定0->1->2->3，G = [0, 1, 3]，在链表中，0和1是相邻的，算一个connect component，3只有
//        一个元素，也算是connected component，所以返回2
//解法描述:用hashset保存子集中的元素，遍历链表，对于当前元素判断是否是在hashset中

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }

        int result = 0;
        while (head != null) {
            if (!set.contains(head.val)) {
                head = head.next;
                continue;
            }

            ++result;
            while (head != null && set.contains(head.val)) {
                set.remove(head.val);
                head = head.next;
            }
        }

        return result;
    }
}
