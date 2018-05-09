package DynamicProgrammimg;

//题目描述:给定两个字符串S和T，可以删除一个字符，替换一个字符，增加一个字符，求最少需要多少步操作，可以使得两个字符串相等
//解法描述: dp,如果S[i] == T[j]，那么dp[i][j] = dp[i - 1][j - 1],如果S[i] != T[j]，那么取这三者的最小值,然后加1，dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // 注意初始化
        for (int i = 0; i < m + 1; ++i) {
            dp[0][i] = i;
        }

        for (int i = 0; i < n + 1; ++i) {
            dp[i][0] = i;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                }
            }
        }

        return dp[n][m];
    }
}
