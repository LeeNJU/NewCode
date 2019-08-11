package Tree;

import Util.TreeNode;

//题目描述:把一个二叉搜索树转换成一个已序的，循环的双向链表
//解法描述:递归

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

    // 把两个循环的链表链接成一个链表
    private TreeNode connect(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        TreeNode cur = root1;
        while (cur.right != root1) {
            cur = cur.right;
        }

        cur.right = root2;
        root2.left = cur;

        cur = root2;
        while (cur.right != root2) {
            cur = cur.right;
        }

        cur.right = root1;
        root1.left = cur;

        return root1;
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = treeToDoublyList(root.left);
        TreeNode right = treeToDoublyList(root.right);

        root.right = root;
        root.left = root;

        root = connect(left, root);
        root = connect(root, right);

        return root;
    }
}
