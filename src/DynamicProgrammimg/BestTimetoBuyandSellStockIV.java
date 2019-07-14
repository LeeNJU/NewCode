package DynamicProgrammimg;

import java.util.stream.IntStream;

//题目描述:最多可以买卖k次，求最大的利润，例如[3,2,6,5,0,3], k = 2，返回最大利润7 = (6 - 2) + (3 - 0)
//解法描述:dp[i][j]表示在[0,j]内交易i次的最大利润，第j填分两种情况，交易和不交易,所以dp[i][j] = max(dp[i][j - 1], max(prices[j] - prices[k] + dp[i - 1][k])),k的范围
//        是[0, j - 1],其中max(prices[j] - prices[k] + dp[i - 1][k]) = prices[j] + max(dp[i - 1][k] - prices[k]),可以用一个变量保存这个值

public class BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 1 || k < 1) {
            return 0;
        }

        int n = prices.length;
        if (k >= n / 2) {
            return IntStream.range(1, n)
                    .filter(index -> prices[index] > prices[index - 1])
                    .map(index -> prices[index] - prices[index - 1])
                    .sum();
        }

        int[][] dp = new int[k + 1][n];

        for (int i = 1; i < k + 1; ++i) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }
}
