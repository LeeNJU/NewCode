package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到最长的连续的递增或者递减序列，起点和终点可以是任意节点
//解法描述:递归，对于每个节点要返回两种结果，递增的最大长度和递减的最大长度

public class BinaryTreeLongestConsecutiveSequenceII {

    private int result = 0;

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] right = dfs(root.right);
        int[] left = dfs(root.left);

        int rightIncreasing = root.right != null && root.right.val == root.val + 1 ? right[1] + 1 : 1;
        int rightDecreasing = root.right != null && root.right.val == root.val - 1 ? right[0] + 1 : 1;
        int leftIncreasing = root.left != null && root.left.val == root.val + 1 ? left[1] + 1 : 1;
        int leftDecreasing = root.left != null && root.left.val == root.val - 1 ? left[0] + 1 : 1;

        result = Math.max(result, rightIncreasing + leftDecreasing - 1);
        result = Math.max(result, rightDecreasing + leftIncreasing - 1);

        int increasing = Math.max(rightIncreasing, leftIncreasing);
        int decreasing = Math.max(leftDecreasing, rightDecreasing);

        return new int[] { decreasing, increasing };
    }

    public int longestConsecutive2(TreeNode root) {
        dfs(root);
        return result;
    }
}
