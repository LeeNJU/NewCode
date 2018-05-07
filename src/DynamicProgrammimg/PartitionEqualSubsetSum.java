package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个正整数数组，判断是否能把数组分成两个子数组，使得两个子数组的和相等，例如[1, 5, 11, 5]，可以分成[1,5,5]和[11]两个子数组
//解法描述:数组的和必须是偶数，问题就转换成找到一个子数组，使得他们的和是总和的一半，背包问题
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums)
                .sum();
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; ++i) {
            // 注意这里要倒叙更新，因为每个元素只能被选择一次
            for (int j = target; j >= nums[i]; --j) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
