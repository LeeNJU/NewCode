package DynamicProgrammimg;

import java.util.List;

//题目描述:给定一个字符串和字符串数组，判断该字符串能否被拆分成字符串数组中的单词，例如s = "leetcode"，
//        dict = "leet", "code"， 那么s能被拆分
//解法描述:动态规划 转移方程dp[i] = dp[i] || dp[j] 如果s[j + 1, i]术语wordDict

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                String str = s.substring(j, i + 1);
                if (wordDict.contains(str)) {
                    dp[i + 1] = dp[i + 1] || dp[j];
                }
            }
        }

        return dp[s.length()];
    }
}
