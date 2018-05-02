package String;

//题目描述:给定一个字符串S，找到其中所有为palindorme的子串的个数，例如S="aaa",所有为palindrome的子串为6个，"a", "a", "a", "aa", "aa", "aaa".
//解法描述:遍历S，以每一个字符为中心店向两边扩展，注意奇数长度和偶数长度的字符串

public class PalindromicSubstrings {

    private int palindrome(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
            ++count;
        }

        return count;
    }

    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            result += palindrome(s, i, i);
            result += palindrome(s, i, i + 1);
        }

        return result;
    }
}
