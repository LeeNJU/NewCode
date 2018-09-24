package String;

//题目描述:给定一个字符串，判断是不是palindrome，忽略大小写，空格和非数字字母元素，例如"A man, a plan, a canal: Panama"，返回true
//解法描述:头尾指针遍历

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j;) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (left == ' ' || !Character.isLetterOrDigit(left)) {
                ++i;
                continue;
            }

            if (right == ' ' || !Character.isLetterOrDigit(right)) {
                --j;
                continue;
            }

            if (left != right) {
                return false;
            }

            ++i;
            --j;
        }

        return true;
    }

    // 版本2:给定一个字符串s，只允许最多删除一个字符，判断是不是palindrom
    // 解法:按照正常方法判断是不是palindrom，如果碰到不相等的字符，可以删除左边或者右边的字符，再判断剩下的字符串是不是palindrom
    private boolean isPalindrom(final String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }

        return i >= j;
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }

        if (i >= j) {
            return true;
        }

        return isPalindrom(s, i + 1, j) || isPalindrom(s, i, j - 1);
    }
}
