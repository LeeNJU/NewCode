package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，有n个节点，总共有n个coin，在父节点和子节点之间移动coin，使得每个节点刚好只有一个coin，求需要多少move
//解法描述:递归

public class DistributeCoinsinBinaryTree {

    private int moves = 0;

    // 函数的含义是需要向父节点移动多少个coin，如果返回值是负数，表示方向相反，父节点需要向该节点移动多少个coin
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        root.val += dfs(root.left);
        root.val += dfs(root.right);

        moves += Math.abs(root.val - 1);
        return root.val - 1;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}
