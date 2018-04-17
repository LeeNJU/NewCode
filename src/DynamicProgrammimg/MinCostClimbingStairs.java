package DynamicProgrammimg;

//题目描述:给定一个非负数组代表台阶的cost，每次可以跳一步或者两步，求到达顶部的最小cost，数组长度至少是2
//解法描述:dp，dp[i] = min(dp[i - 1], dp[i  -2]) + cost[i],由于只需要前两个值，所以是常数空间，注意最后返回二者的最小值，因为二者都可以到达顶部

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0], b = cost[1];

        for (int i = 2; i < cost.length; ++i) {
            int c = Math.min(a, b) + cost[i];
            a = b;
            b = c;
        }

        return Math.min(a, b);
    }
}
