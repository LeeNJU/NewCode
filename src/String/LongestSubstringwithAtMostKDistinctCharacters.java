package String;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个字符串以及k值，找到最长的子字符串，使得子字符串最多包含k个不同的字符，例如S = "eceba" and k = 3，返回4，因为T = "eceb"
//解法描述:双指针维护一个窗口，窗口中的元素用hashmap记录

public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int length = 0;
        for (int right = 0; right < s.length(); ++right) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }

                ++left;
            }

            length = Math.max(length, right - left + 1);
        }

        return length;
    }
}
