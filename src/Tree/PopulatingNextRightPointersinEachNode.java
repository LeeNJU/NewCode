package Tree;

import Util.TreeLinkNode;

//题目描述:给定一个二叉树，把所有的节点都指向右边的节点
//解法描述:层次遍历，用一个dummy node，遍历第一层的时候，把下一层连接起来，然后遍历下一层

public class PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode prev = dummy;

        while (root != null) {
            while (root != null) {
                if (root.left != null) {
                    prev.next = root.left;
                    prev = root.left;
                }

                if (root.right != null) {
                    prev.next = root.right;
                    prev = root.right;
                }

                root = root.next;
            }

            root = dummy.next;
            dummy.next = null; // 注意这里，必须要设为null，否则最后一行会死循环
            prev = dummy;
        }
    }
}
