package String;

//题目描述：给定一个字符串s，找到其中最大的回文子串
//解法描述：暴力法，列举回文子串的中心字符，向左右两边扩展,要注意奇数回文串和偶数回文串的区别
public class LongestPalindromicSubstring {

    private int palindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }

        return j - i - 1;
    }

    public String longestPalindrome(String s) {
        int length = 0;
        int index = 0;
        for (int i = 0; i < s.length(); ++i) {
            int count = palindrome(s, i, i);
            // 判断奇数回文串
            if (count > length) {
                length = count;
                index = i - count / 2;
            }

            // 判断偶数回文串
            count = palindrome(s, i, i + 1);
            if (count > length) {
                length = count;
                index = i - count / 2 + 1;
            }
        }

        return s.substring(index, index + length);
    }
}
