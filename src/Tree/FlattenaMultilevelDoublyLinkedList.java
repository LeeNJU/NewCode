package Tree;

import Util.Node;

//题目描述:给定一个链表，扁平化，例如1---2---3---4---5---6--NULL
//                                      |
//                                      7---8---9---10--NULL
//                                          |
//                                          11--12--NULL
//        返回1-2-3-7-8-11-12-9-10-4-5-6-NULL
//解法描述:本质上就是树的前序遍历

public class FlattenaMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node root = new Node(head.val);
        if (head.child != null) {
            root.next = flatten(head.child);
            root.next.prev = root;
        }

        Node node = root;
        while (node.next != null) {
            node = node.next;
        }

        if (head.next != null) {
            node.next = flatten(head.next);
            node.next.prev = node;
        }
        return root;
    }
}
