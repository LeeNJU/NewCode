package LinkedList;

import Util.ListNode;
import Util.TreeNode;

//题目描述:给定一个递增的链表，把链表转换成平衡的二叉搜索树，答案可能有多种
//解法描述:快慢指针找到根节点，然后一分为二进行递归，注意dummy节点和快慢指针的使用

public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fast = head, slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;
        prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);

        return root;
    }
}
