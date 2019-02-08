package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，判断所有节点的值是不是一样的
//解法描述:递归

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        final boolean left = isUnivalTree(root.left);
        final boolean right = isUnivalTree(root.right);

        return left && right && (root.left == null || root.val == root.left.val) && (root.right == null || root.right.val == root.val);
    }
}
