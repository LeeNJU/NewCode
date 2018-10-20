package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到最大的子树，使其实二叉搜索树，例如
//             10
//            /  \
//           5   15
//          / \   \
//         1  8    7  最大的二叉搜索子树是1，5，8，返回它的大小
//解法描述:递归，返回的结果包括子树是否是二叉搜索树，子树的大小，最小值和最大值

public class LargestBSTSubtree {

    private int result = 0;

    private int[] dfs(TreeNode root) {
        int[] nums = new int[4];
        if (root == null) {
            nums[0] = 1;
            nums[1] = 0;
            // 表示最小值，用最大值初始化
            nums[2] = Integer.MAX_VALUE;
            nums[3] = Integer.MIN_VALUE;
            return nums;
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        nums[2] = Math.min(root.val, Math.min(left[2], right[2]));
        nums[3] = Math.max(root.val, Math.max(left[3], right[3]));

        if (left[0] == 1 && right[0] == 1 && root.val > left[3] && root.val < right[2]) {
            nums[0] = 1;
            nums[1] = left[1] + right[1] + 1;
            result = Math.max(result, nums[1]);
            nums[2] = Math.min(root.val, left[2]);
            nums[3] = Math.max(root.val, right[3]);
            return nums;
        }

        nums[0] = 0;
        nums[1] = 0;

        return nums;
    }

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return result;
    }
}
