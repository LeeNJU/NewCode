package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，判断是不是满二叉树，也就是每一个节点要么没有子节点，要么有两个子节点
//解法描述:递归

public class CheckFullBinaryTree {

    public boolean isFullTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return isFullTree(root.left) && isFullTree(root.right);
    }
}
