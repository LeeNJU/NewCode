package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，判断是不是对称的二叉树
//解法描述:递归

public class SymmetricTree {

    private boolean isSymmetric(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }
}
