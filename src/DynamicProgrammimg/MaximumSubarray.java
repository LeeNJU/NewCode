package DynamicProgrammimg;

//题目描述：给定一个数组，从中找到连续的子数组，使得子数组的和最大
//解法描述：动态规划，维护两个变量，局部最优解保存包含当前元素的最优解，全局最优解表示从初始位置到当前元素的最优解。

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int result = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            // local maximum
            cur = Math.max(cur + nums[i], nums[i]);
            result = Math.max(result, cur);
        }

        return result;
    }
}
