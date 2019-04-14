package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Util.ListNode;

//题目描述:给定一个链表，找到每一个元素next greater element，例如[1,7,5,1,9,2,5,1]，返回[7,9,9,9,0,5,0,0]
//解法描述:类似于next greater element的解法

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        int length = 0;
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (cur != null) {
            ++length;

            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                map.put(stack.pop(), cur);
            }

            stack.add(cur);
            cur = cur.next;
        }

        int[] result = new int[length];
        cur = head;
        int index = 0;
        while (cur != null) {
            result[index++] = map.containsKey(cur) ? map.get(cur).val : 0;
            cur = cur.next;
        }

        return result;
    }
}
