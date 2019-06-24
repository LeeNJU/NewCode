package DynamicProgrammimg;

//题目描述:给定一个正整数数组，两个选手轮流选择元素，每次只能选择数组的第一个元素或者最后一个元素，判断第一个选手能不能赢
//解法描述:dp[i][j]表示第一个元素能够得到的最大分数，dp[i][j] = max( min (dp[i + 1][j - 1], dp[i + 2][ j]) + v[i], min (dp[i][j - 2], dp[i + 1][ j - 1]) + v[j]})
//        [i,j],第一个选手只能选择i或者j，如果选择i，那么第二个选手就必须从[i + 1, j]之间选择，由于两个选手都是optimal的策略，第二个选手只能选择i + 1或者j，导致dp[i + 2][j]或者
//        dp[i + 1][j - 1]的分数变小，只能选择二者之中最小的(optimal策略)

public class PredicttheWinner {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }

        for (int length = 1; length < n; ++length) {
            for (int i = 0; i < n && i + length < n; ++i) {
                int j = i + length;
                int a = i + 1 < n && j - 1 >= 0 ? dp[i + 1][j - 1] : 0;
                int b = j - 2 >= 0 ? dp[i][j - 2] : 0;
                int c = i + 2 < n ? dp[i + 2][j] : 0;

                dp[i][j] = Math.max(Math.min(a, c) + nums[i], Math.min(b, a) + nums[j]);
            }
        }

        return dp[0][n - 1] * 2 >= sum;
    }
}
