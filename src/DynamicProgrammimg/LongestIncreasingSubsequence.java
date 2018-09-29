package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个数组，找到最长的递增子序列，子序列不一定要连续
//解法描述:动态规划，dp[i] = max(dp[i], dp[j] + 1),其中nums[j]要比nums[i]小，表示找到一个可能的递增子序列
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
