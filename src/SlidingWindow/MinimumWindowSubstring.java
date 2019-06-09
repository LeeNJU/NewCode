package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定两个字符串s和t，在s中找到最短的子字符串，使得该子字符串包含t中的所有字符，例如S = "ADOBECODEBANC", T = "ABC"，最短的子字符串是"BANC"
//解法描述:双pointer的解法，[left, right]表示子字符串，count记录这个区间里有多少个字符属于t

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int length = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); ++right) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) - 1);
            // 遇到了t中的元素
            if (map.get(s.charAt(right)) >= 0) {
                ++count;
            }

            // 找到一个解
            while (count == t.length()) {
                if (length > right - left + 1) {
                    length = right - left + 1;
                    result = s.substring(left, right - left + 1);
                }

                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
                if (map.get(s.charAt(left)) > 0) {
                    --count;
                }

                ++left;
            }
        }

        return result;
    }
}
