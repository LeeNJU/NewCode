package DynamicProgrammimg;

//题目描述:给定一个数组表示股票价格，可以多次交易，但是每次有交易费，求最大的利润
//解法描述:dp[i]分两种状态，cash表示第i天没有股票的最大利润，手里没有股票，可能是第i天卖出了，也可能是跟前一天保持相同，hold表示第i天手里有股票的最大利润，可能是今天买入了，也有可能是保持相同
//        由于只需要前一天的数据，不需要数组

public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {

        // the max profit you have if you don't have a stock that day
        int cash = 0;
        // the max profit you have if you have a stock that day, if you have a stock the first day,hold=-prices[0]
        int hold = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            // cash in day i is the maxvalue of cash in day i-1 or you sell your stock
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
