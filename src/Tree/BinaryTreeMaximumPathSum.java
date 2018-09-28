package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到最大的路径和，其中起始点可以是任意节点，终止节点也可以是任意节点。但是必须满足
//         parent-child关系
//解法描述:最优解可能存在于某个树的子树(局部解)，所以用result引用。 对于任意一个节点，有4种情况，左子树的路径，右子树
//         的路径，节点本身，以及左子树的路径 + 节点本身 + 右子树的路径

public class BinaryTreeMaximumPathSum {

    private int result = Integer.MIN_VALUE;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int sum = root.val + Math.max(left, right);
        sum = Math.max(sum, root.val);
        result = Math.max(sum, result);
        result = Math.max(result, left + right + root.val);

        return sum;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }
}
