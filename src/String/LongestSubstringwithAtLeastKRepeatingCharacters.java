package String;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个字符串和k值，找到最长的子字符串，使得子字符串中的每个字符出现次数大于等于k，例如"aaabb", k = 3,返回3，"ababbc", k = 2，返回5
//解法描述:递归，对当前字符串，统计每个字符的出现次数，如果每个字符出现次数都大于等于k，那么直接返回字符串长度，如果有字符的次数小于k，以这些字符把整个字符串划分成小的字符串，那么最优解必然存
//        在于这些小字符串中，然后对这些小字符串递归调用。

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean exist = map.keySet()
                .stream()
                .allMatch(c -> map.get(c) >= k);

        if (exist) {
            return s.length();
        }

        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) < k) {
                result = Math.max(result, longestSubstring(s.substring(j, i), k));
                j = i + 1;
            }
        }

        result = Math.max(result, longestSubstring(s.substring(j), k));
        return result;
    }
}
