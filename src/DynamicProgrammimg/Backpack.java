package DynamicProgrammimg;

//题目描述:背包问题,给定一个数组和一个值w，从数组中选出几个元素，值得元素之和尽可能接近w
//解法描述:dp[i][j]表示从1到第i个元素要装满j的空间，分成两种情况，dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 
//        A[i - 1]] + A[i - 1]).如果不选择第i个元素，那么dp[i][j] = dp[i - 1][j],如果选择第i个元素,那么就是
//        dp[i - 1][j - A[i - 1]]，由于更新dp[i][j]只需要上一层的信息，可以优化空间，只需要一维数组

public class Backpack {

    public int backPack(int m, int[] A) {
        int[] dp = new int[m + 1];

        for (int i = 0; i < A.length; ++i) {
            for (int j = m; j >= A[i]; --j) {
                dp[j] = Math.max(dp[j - A[i]] + A[i], dp[j]);
            }
        }

        return dp[m];
    }
}
