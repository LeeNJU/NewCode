package DynamicProgrammimg;

//题目描述:给定两个字符串word1和word2，每次可以删除一个元素，求最少需要删除多少个元素可以使得两个字符串相等，例如"sea", "eat"，删除2次
//解法描述:dp[i][j]表示最少需要删除的个数

public class DeleteOperationforTwoStrings {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word2.length(); ++i) {
            dp[0][i + 1] = i + 1;
        }

        for (int i = 0; i < word1.length(); ++i) {
            dp[i + 1][0] = i + 1;
        }

        for (int i = 0; i < word1.length(); ++i) {
            for (int j = 0; j < word2.length(); ++j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1] + 1, dp[i + 1][j] + 1), dp[i][j] + 2);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
