package DynamicProgrammimg;

//题目描述:找到两个字符串的最长公共子序列
//解法描述:dp[i][j]表示[0,i]和[0,j]之间的最长公共子序列

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[n][m];
    }
}
