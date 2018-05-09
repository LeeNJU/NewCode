package DynamicProgrammimg;

//题目描述:给定一个二维数组，只包含0和1，找到其中全是1的最大的正方形的面积
//解法描述:dp,先求长度再求面积，dp[i][j]表示以matrix[i][j]结尾的最大的正方形的长度，递推公式是取dp[i - 1][j - 1],dp[i - 1][j]和dp[i][j - 1]的最小值，然后加1

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];

        int maxLength = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }

                maxLength = Math.max(maxLength, dp[i + 1][j + 1]);
            }
        }

        return maxLength * maxLength;
    }
}
