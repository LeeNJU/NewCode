package DynamicProgrammimg;

//题目描述：给定一个数组表示每个股票的价钱，找到其中两个数，使他们的差最大，返回这个差值
//解法描述：贪心，假设当前第一个元素是最小值

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // 差价，也就是利润
        int result = 0;
        // 假设当前最小
        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }

    public int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; ++i) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }

        return result;
    }

    // version 3
    // 题目描述：同样的数组，最多只能两次交易，求最大的profit，一天可以同时卖出和买进
    // 解法描述：两次交易必然在两个区间，所以可以以每个元素进行划分，区间0 - i和(i + 1) - (n - 1)，最后的结果应该
    // 是二者和的最大值。用动态规划dp[i]表示0 - i的最大profit，先扫描一遍得到0到n的最大值，然后从右往左
    // 扫描，保存最大值，求出i到n的最大值，也就是第二个交易的最大值，最后的结果是二者之和
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(prices[i], min);
        }

        int result = 0;
        int max = prices[prices.length - 1];
        int profit = 0;
        for (int i = prices.length - 2; i >= 0; --i) {
            profit = Math.max(profit, max - prices[i]);
            max = Math.max(max, prices[i]);

            result = Math.max(result, dp[i] + profit);
        }

        return result;
    }
}
