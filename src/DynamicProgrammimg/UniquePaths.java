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

    // 题目描述:二维数组包含0和1，1代表障碍，不能通过，求这种情况下，从左上角到右下角总共有多少种走法
    // 解法描述:dp, 与上题类似，但是dp[i][0]和dp[0][j]不一定全是为1，有可能为0，注意第一个元素的初始化
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }

                if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[m - 1];
    }
}
