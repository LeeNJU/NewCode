package LinkedList;

import Util.ListNode;

//题目描述:给定一个链表节点，从链表中删除该节点
//解法描述:跟下一个节点的值进行交换，然后删除下一个节点

public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        int val = node.next.val;
        node.val = val;
        node.next = node.next.next;
    }
}
