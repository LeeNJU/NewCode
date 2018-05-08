package DynamicProgrammimg;

//题目描述:给定两个字符串S和T，求在S中有多少个子序列与T相等，例如S = "rabbbit", T = "rabbit"， 返回3，因为S中有3中可能的子序列和T相同
//解法描述:dp, dp[i][j]表示S[0-i]和T[0-j]中有多少个子序列和T[0-j]相同，如果S[i] == T[j],那么dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j],如果不等，
//        那么dp[i][j] = dp[i - 1][j].由于只需要dp[i - 1][j - 1]和dp[i - 1][j]的信息，只需要一维滚动数组即可，注意这里要倒叙更新

public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        int[] dp = new int[T.length() + 1];
        dp[0] = 1;

        for (int i = 0; i < S.length(); ++i) {
            // 注意这里要倒叙更新，因为需要dp[i - 1][j - 1]的值
            for (int j = T.length() - 1; j >= 0; --j) {
                dp[j + 1] += S.charAt(i) == T.charAt(j) ? dp[j] : 0;
            }
        }

        return dp[T.length()];
    }
}
