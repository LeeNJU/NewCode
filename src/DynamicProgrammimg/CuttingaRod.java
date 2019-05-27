package DynamicProgrammimg;

//题目描述:给定一个长度为n的木棍，以及一个价格数组，把木棍分成多个小木棍，求最大的价格，例如n = 8，[1, 5, 8, 9, 10, 17, 17, 20]表示长度为1的价格是1，长度为2的价格是5，
//       以此类推，返回22，可以分成长度为2和长度为6
//解法描述:dp[i] = max(dp[i], dp[j] + price)

public class CuttingaRod {

    public int cutting(int[] prices, int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; ++i) {
            for (int j = i; j > 0; --j) {
                dp[i] = Math.max(dp[i], dp[j - 1] + prices[i - j]);
            }
        }

        return dp[n];
    }
}
