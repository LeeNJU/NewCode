package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//题目描述:给定一个字符串，判断该字符串的某个组合能不能组成一个回文串，例如"aab"可以组成"aba"
//解法描述:如果能够组成回文串，那么字符出现的次数为偶数，最多只能有一个字符的出现次数为奇数

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                ++count;
            }
        }
        return count < 2;
    }

    // 版本2:给定一个字符串s，找到所有的permutation，使得每个permutaton都是palindrome，例如Given s = "aabb", return ["abba","baab"].如果没有返回[]
    // 解法描述；统计每个字符的次数，从起始字符串开始，每次在左边和右边添加两个相同的字符

    private void dfs(String s, int length, List<String> result, Map<Character, Integer> map) {
        if (s.length() == length) {
            result.add(s);
            return;
        }

        for (Character c : map.keySet()) {
            if (map.get(c) > 1) {
                map.put(c, map.get(c) - 2);
                dfs(c + s + c, length, result, map);
                map.put(c, map.get(c) + 2);
            }
        }
    }

    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        char c = ' ';
        for (Character ch : map.keySet()) {
            if (map.get(ch) % 2 == 1) {
                ++count;
                c = ch;
            }
        }

        List<String> result = new ArrayList<String>();
        if (count > 1) {
            return result;
        }

        dfs((count == 1 ? Character.toString(c) : ""), s.length(), result, map);
        return result;
    }
}
