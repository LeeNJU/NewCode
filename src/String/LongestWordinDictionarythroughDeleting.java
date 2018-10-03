package String;

import java.util.List;

//题目描述:给定一个字符串s和一个字符串数组d，在d中找到最长的字符串，使得它是s的子串，如果长度相等，按照字母顺序返回第一个，例如s = "abpcplea", d = ["ale","apple","monkey","plea"]
//        返回"apple"
//解法描述:遍历字符串数组，依次判断是不是s的字符串，并保留长度最长且字母表顺序最小的字符串

public class LongestWordinDictionarythroughDeleting {

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

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String str : d) {
            final boolean isSubsequence = isSubsequence(s, str);
            if (isSubsequence && str.length() > result.length()) {
                result = str;
            }

            if (isSubsequence && str.length() == result.length() && str.compareTo(result) < 0) {
                result = str;
            }
        }

        return result;
    }
}
