package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，和两个值x和y，判断x和y节点是不是cousin节点，即在树的同一层，但是父节点不同
//解法描述:dfs找到x和y的深度和父节点

public class CousinsinBinaryTree {

    private int depthX = 0;
    private int depthY = 0;
    private TreeNode parentX = null;
    private TreeNode parentY = null;

    private void dfs(final TreeNode root, int x, int y, int level) {
        if (root == null) {
            return;
        }

        if ((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)) {
            depthX = level;
            parentX = root;
        }

        if ((root.left != null && root.left.val == y) || (root.right != null && root.right.val == y)) {
            depthY = level;
            parentY = root;
        }

        dfs(root.left, x, y, level + 1);
        dfs(root.right, x, y, level + 1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 1);
        return depthX == depthY && parentX != parentY;
    }
}
