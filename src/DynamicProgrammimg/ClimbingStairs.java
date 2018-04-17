package DynamicProgrammimg;

//题目描述:给定一个正数n，表示n个台阶，从0开始跳，每次跳一步或者两步，求到达n的最小步数
//解法描述:动态规划，dp[i] = dp[i - 1] + dp[i - 2]

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
