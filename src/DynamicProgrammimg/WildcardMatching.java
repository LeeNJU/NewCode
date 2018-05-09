package DynamicProgrammimg;

//题目描述:给定一个字符串S和模式P，判断s是否能够匹配模式p，?可以匹配任意一个元素，*可以匹配任意长度的元素，包括空字符
//解法描述:动态规划，dp[i][j]表示从字符串s的0到i，能否匹配字符串p的0到j，如果p[j]不是*或者?,那么dp[i][j] =
////        dp[i - 1][j - 1] && s[i] == p[j],如果p[j]等于?,那么dp[i][j] = dp[i - 1][j - 1],如果p[j] == *,
////        那么dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 2][j - 1] ||...dp[0][j - 1].
////        因为dp[i - 1][j] = dp[i - 1][j - 1] || dp[i - 2][j - 1] || dp[i - 3][j - 1]...所以可以简化为
////        dp[i][j] = dp[i][j - 1] || dp[i - 1][j]

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 0; i < m; ++i) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = false;
                }
            }
        }

        return dp[n][m];
    }
}
