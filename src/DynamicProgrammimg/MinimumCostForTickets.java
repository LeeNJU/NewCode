package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个数组，代表天数，另一个数组代表1-day，7-day和30-day的票价，要求数组中的每一天都在travel，求最小的票价之和，例如days = [1,4,6,7,8,20], costs = [2,7,15]
//       第1天买1-day的票可以覆盖第1天，第3天买7-day的票可以覆盖到第8天，第20天买1-day的票可以覆盖最后一天，最小的票价之和是11
//解法描述:对于dp[i]表示前i天被cover掉的最小票价，可以通过买1-day，7-day和30-day的票价进行cover，dp[i] = min(dp[j - 1] + 票价, dp[i]),其中[j, i]可以被某一种票价cover
//       注意这里要用dp[j - 1],因为每一天必须被cover，如果用dp[j],票价会重复

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for (int i = 1; i < days.length; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (days[i] - days[j] < 1) {
                    dp[i + 1] = Math.min(dp[j] + costs[0], dp[i + 1]);
                }

                if (days[i] - days[j] < 7) {
                    dp[i + 1] = Math.min(dp[j] + costs[1], dp[i + 1]);
                }

                if (days[i] - days[j] < 30) {
                    dp[i + 1] = Math.min(dp[j] + costs[2], dp[i + 1]);
                }
            }
        }

        return dp[days.length];
    }
}
