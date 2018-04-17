package DynamicProgrammimg;

import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums)
                .sum();

        if (S > Math.abs(sum)) {
            return 0;
        }

        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;

        for (int i = 0; i < nums.length; ++i) {
            int[] next = new int[2 * sum + 1];

            for (int k = 0; k < 2 * sum + 1; ++k) {
                if (dp[k] != 0) {
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }
}
