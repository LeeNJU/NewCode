package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个二维数组，每一行选中一个元素，选中元素之间的纵坐标的差不超过1，使得他们的和最小，例如[[1,2,3],[4,5,6],[7,8,9]]，可以选择[1,4,7]，返回最小和12
//解法描述:dp[i][j]表示第i行第j列的元素被选中的最小和，那么dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j],可以直接修改原数组

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        int n = A.length, m = A[0].length;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int left = j - 1 >= 0 ? A[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = j + 1 < m ? A[i - 1][j + 1] : Integer.MAX_VALUE;

                A[i][j] += Math.min(Math.min(left, right), A[i - 1][j]);
            }
        }

        // 最后扫描最后一行取最小值
        return Arrays.stream(A[n - 1])
                .min()
                .getAsInt();
    }
}
