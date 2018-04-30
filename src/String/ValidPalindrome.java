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
}
