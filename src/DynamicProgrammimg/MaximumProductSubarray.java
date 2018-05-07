package DynamicProgrammimg;

//题目描述:给定一个数组，包含正数和负数，求最长的连续子数组，使得他们的乘积最大，例如[2,3,-2,4]，最大乘积是2 * 3，返回6
//解法描述:dp, dp[i]表示以i结尾的子数组的最大值，局部解，最大值可能是负负得正或者正正得正，所以需要保存局部解的最大值和最小值

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int result = nums[0];
        int local_max = nums[0];
        int local_min = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            // 注意更新的时候要保持顺序
            int t = local_max;
            local_max = Math.max(local_max * nums[i], nums[i]);
            local_max = Math.max(local_max, local_min * nums[i]);

            local_min = Math.min(t * nums[i], local_min * nums[i]);
            local_min = Math.min(local_min, nums[i]);

            result = Math.max(result, local_max);
        }

        return result;
    }
}
