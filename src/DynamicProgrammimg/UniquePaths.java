package DynamicProgrammimg;

//题目描述:给定二维数组，从左上角出发到右下角，求总共有多少种不同的走法，每次只能向下或者向右移动
//解法描述:dp, dp[i][j] = dp[i][j - 1] + dp[i - 1][j],由于只用到前面两个元素，可以优化成一维数组

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
