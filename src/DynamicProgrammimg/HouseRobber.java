package DynamicProgrammimg;

//题目描述：给定一个整数数组代表每个家庭的钱，现在去抢劫，但是不能抢劫相连的两家，求最大能抢劫多少钱
//解法描述：动态规划  dp[i] = max(dp[i - 1], dp[i - 2] + n[i]),由于只需要前面两个值，可以优化成常数空间

import Util.TreeNode;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int f1 = nums[0];
        int f2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {
            int f3 = Math.max(f1 + nums[i], f2);

            f1 = f2;
            f2 = f3;
        }

        return f2;
    }

    // 变种2：假设房子的排列是首尾相连的，即第一个房子和最后一个房子是相邻的，不能同时抢劫
    // 解法描述:由于第一家和最后一家不能同时抢，那就分别把第一家和最后一家去掉，分别算出能够抢的最大值，然后二者取最大
    private int rob(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return nums[left];
        }

        int prev = 0, cur = nums[left];
        for (int i = left + 1; i <= right; ++i) {
            int t = Math.max(cur, prev + nums[i]);
            prev = cur;
            cur = t;
        }

        return cur;
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    // 变种3:
    // 房子被组织成二叉树的形式，父子节点不能同时被抢，求能抢到的最大值
    // 解法描述:递归，用一个pair表示值，pair.first表示抢当前节点的最大值，pair.second表示不抢当前节点的最大值
    private int[] rob3(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }

        int[] left = rob3(root.left);
        int[] right = rob3(root.right);

        result[0] = left[1] + right[1] + root.val;
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }

    public int rob(TreeNode root) {
        int[] result = rob3(root);
        return Math.max(result[0], result[1]);
    }
}
