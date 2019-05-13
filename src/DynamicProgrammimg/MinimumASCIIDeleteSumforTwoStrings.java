package DynamicProgrammimg;

//题目描述:给定两个字符串s1和s2，每次可以删除一个元素，把被删除的元素的ASCII求和，求最小的ASCII和，使得两个字符串相等，例如"sea", "eat"，删除2次
//解法描述:DeleteOperationforTwoStrings一模一样

public class MinimumASCIIDeleteSumforTwoStrings {

    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s2.length(); ++i) {
            dp[0][i + 1] = dp[0][i] + s2.charAt(i);
        }

        for (int i = 0; i < s1.length(); ++i) {
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        }

        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1] + s1.charAt(i), dp[i + 1][j] + s2.charAt(j)), dp[i][j] + s1.charAt(i) + s2.charAt(j));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
