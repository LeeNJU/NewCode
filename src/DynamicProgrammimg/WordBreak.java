package DynamicProgrammimg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//题目描述:给定一个字符串和字符串数组，判断该字符串能否被拆分成字符串数组中的单词，例如s = "leetcode"，
//        dict = "leet", "code"， 那么s能被拆分
//解法描述:动态规划 转移方程dp[i] = dp[i] || dp[j] 如果s[j + 1, i]属于wordDict

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

    // 变种二
    // 题目描述:给定一个字符串和字符串数组，返回该字符串被拆分成字符串数组中的单词
    // 解法描述:直接递归生成所有的解，但是要注意剪枝

    // 当前递归的含义是，返回s所有能生成的字符串
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        // 注意这里的结束条件，必须返回空字符串
        List<String> result = new ArrayList<String>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (String str : wordDict) {
            if (s.startsWith(str)) {
                List<String> list = dfs(s.substring(str.length()), wordDict, map);
                list.stream()
                        .forEach(string -> result.add(str + (string.isEmpty() ? "" : " ") + string));
            }
        }

        map.put(s, result);
        return result;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, wordDict, map);
    }
}
