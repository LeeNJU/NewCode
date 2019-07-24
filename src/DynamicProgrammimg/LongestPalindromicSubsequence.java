package DynamicProgrammimg;

//题目描述:给定一个字符串，找到长度最长的子序列，使得子序列是palindrome，例如"bbbab"，长度最长的palindrome子序列是"bbbb"，返回4
//解法描述:对角线更新的dp，如果s[i] == s[j], dp[i][j] = dp[i + 1][j - 1] + 2,如果s[i] != s[j],那么dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]); 

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int length = 2; length <= n; ++length) {
            for (int i = 0; i < n && i + length - 1 < n; ++i) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
