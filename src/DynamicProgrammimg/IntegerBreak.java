package DynamicProgrammimg;

//题目描述:给定一个正整数n，把n分成多个正整数的和，使得乘积最大，例如n = 10，分解成3，3和4，可以得到最大乘积36
//解法描述:dp[i]表示把i分成多个正整数能得到的最大乘积，那么dp[i] = max(dp[i - j] * j, (i - j) * j, dp[i]), 其中(i - j) * j表示只分成两个数，不再继续分解的情况
//        dp[i - j]表示继续分解i - j的情况，此题还有O(n)的解法，需要找规律

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; i - j >= 1; ++j) {
                dp[i] = Math.max(Math.max(dp[i - j] * j, dp[i]), (i - j) * j);
            }
        }

        return dp[n];
    }
}
