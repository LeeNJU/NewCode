package DynamicProgrammimg;

//题目描述:给定三个字符串s1,s2和s3,判断s3是否可以由s1和s2interleaving组成，例如s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"，返回true
//解法描述:dp[i + 1][j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1) && dp[i][j + 1]) || (s2.charAt(j) == s3.charAt(i + j + 1) && dp[i + 1][j]);

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        // 初始化第一行
        for (int i = 1; i < dp[0].length; ++i) {
            dp[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1];
        }

        // 初始化第一列
        for (int i = 1; i < dp.length; ++i) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
        }

        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                dp[i + 1][j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1) && dp[i][j + 1]) || (s2.charAt(j) == s3.charAt(i + j + 1) && dp[i + 1][j]);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
