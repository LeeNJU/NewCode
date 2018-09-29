package String;

import java.util.HashMap;

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
}
