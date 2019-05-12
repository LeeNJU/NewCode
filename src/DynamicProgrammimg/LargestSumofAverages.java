package DynamicProgrammimg;

//题目描述:给定一个整数数组和一个K值，可以把这个数组最多分成k个group，可以得到每个group的平均值的和，求这个最大值，例如A = [9,1,2,3,9]，K = 3，能分成
//       [9], [1, 2, 3], [9],使得平均值的和最大为20
//解法描述:dp[i][j]表示[0,j]的元素分成i - 1组的最大平均值和，dp[i][j] = max(dp[i][j], dp[i - 1][k] + sum(k + 1, j) / (j - k)),对于元素A{j]，可以和[k,j]
//       分成一组

public class LargestSumofAverages {

    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[K][A.length + 1];
        double sum = 0.0;
        // 初始化K = 1的情况
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            dp[0][i + 1] = sum / (i + 1);
        }

        for (int i = 1; i < K; ++i) {
            for (int j = 0; j < A.length; ++j) {
                sum = 0.0;
                for (int k = j; k >= 0; --k) {
                    sum += A[k];
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i - 1][k] + sum / (j - k + 1));
                }
            }
        }

        return dp[K - 1][A.length];
    }
}
