package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个二维数组，包含非负整数，求从左上角到右下角的和最小，每次只能向右或者向下移动
//解法描述:dp, dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j],由于只需要前面两个元素，可以只用一维数组

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 第一个元素要特殊处理
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }

        return dp[m - 1];
    }
}
