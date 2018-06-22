package LinkedList;

import java.util.ArrayList;
import java.util.List;

import Util.ListNode;

//题目描述:给定一个链表，倒序存储在数组中，例如给定1 -> 2 -> 3 -> null, return [3,2,1].
//解法描述:递归

public class ReverseOrderStorage {

    public List<Integer> reverseStore(ListNode head) {
        if (head == null) {
            return new ArrayList<>();
        }

        List<Integer> list = reverseStore(head.next);
        list.add(head.val);
        return list;
    }
}
