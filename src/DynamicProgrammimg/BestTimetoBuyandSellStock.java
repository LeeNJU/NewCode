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
}
