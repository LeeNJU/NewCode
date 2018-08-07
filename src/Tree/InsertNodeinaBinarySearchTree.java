package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，插入一个节点
//解法描述:二分遍历，保留parent节点

public class InsertNodeinaBinarySearchTree {

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            parent = cur;
            if (cur.val < node.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (parent.val < node.val) {
            parent.right = node;
        } else {
            parent.left = node;
        }

        return root;
    }
}
