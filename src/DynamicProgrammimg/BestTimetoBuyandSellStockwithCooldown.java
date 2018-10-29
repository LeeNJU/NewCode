package DynamicProgrammimg;

//题目描述:股票买卖问题，卖完股票之后必须等1天才能再买
//解法描述:dp，第i天手里有股票和没有股票两种状态

public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int cash = 0;
        // 前一天卖股票后的状态
        int prev = 0;

        for (int i = 1; i < prices.length; ++i) {
            int temp = cash;
            // 手里没有股票，有可能是保持前一天的状态，有可能是今天买了股票
            cash = Math.max(cash, hold + prices[i]);
            // 手里有股票，有可能是保持前一天的状态，也有可能是今天买了股票，如果是今天买了股票，因为有1天的cool down，所以需要前一天卖股票的状态
            hold = Math.max(hold, prev - prices[i]);

            prev = temp;
        }

        return cash;
    }
}
