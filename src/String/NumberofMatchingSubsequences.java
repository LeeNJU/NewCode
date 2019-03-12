package String;

import java.util.Arrays;

//题目描述:给定一个字符串S和一个字符串数组，求有多少个字符串是S的subsequence
//解法描述:暴力解

public class NumberofMatchingSubsequences {

    private boolean isSubsequence(final String s, final String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                ++j;
            }

            ++i;
        }

        return j >= t.length();
    }

    public int numMatchingSubseq(String S, String[] words) {
        return (int) Arrays.stream(words)
                .filter(word -> isSubsequence(S, word))
                .count();
    }
}
