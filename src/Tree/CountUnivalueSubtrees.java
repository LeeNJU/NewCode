package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，求出uni-value subtree的子树，uni-value subtree指该子树所有的节点的值都一样，例如
//              5          应该返回4
//            1    5
//          5   5    5
//解法描述:递归，关键是判断子树是不是uni-value subtres
public class CountUnivalueSubtrees {

    private int result = 0;

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        if (left && right && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
            ++result;
            return true;
        }

        return false;
    }

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }
}
