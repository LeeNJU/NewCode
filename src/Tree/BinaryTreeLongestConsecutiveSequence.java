package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到找到连续的最长路径，例如
//      1
//        \
//         3
//        / \
//       2   4
//            \
//             5   最长的路径是3-4-5，返回长度3
//解法描述:递归，计算当前节点的最大长度，局部解

public class BinaryTreeLongestConsecutiveSequence {

    private int result = 0;

    public int getResult() {
        return this.result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 左右节点的最大长度
        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftLength = (root.left != null && root.val + 1 == root.left.val) ? left + 1 : 1;
        int rightLength = (root.right != null && root.val + 1 == root.right.val) ? right + 1 : 1;

        int num = Math.max(leftLength, rightLength);
        result = Math.max(result, num);
        return num;
    }

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return result;
    }
}
