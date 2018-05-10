package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个数组表示硬币的值，再给一个值，要求用最少数量的硬币凑成这个值
//解法描述:动态规划 dp[i] = min(dp[i], dp[i - coins[j]] + 1)

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            if (coin < amount + 1) {
                dp[coin] = 1;
            }
        }

        // 注意，外循环从coin开始，表示求的是组合的情况，如果外循环从amount开始，表示求的是排列的情况
        // 此题组合和排列的结果是一样的，因为不改变需要的硬币数量
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j < dp.length; ++j) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
