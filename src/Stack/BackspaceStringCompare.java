package Stack;

//题目描述:给定两个字符串S和T，只包含小写字母和#，#代表后退一格，判断两个字符串是否相等，例如S = "ab#c", T = "ad#c"，返回true
//解法描述:从后面扫描，记录#出现的次数，

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int count1 = 0, count2 = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || count1 > 0)) {
                count1 = S.charAt(i--) == '#' ? count1 + 1 : count1 - 1;
            }

            while (j >= 0 && (T.charAt(j) == '#' || count2 > 0)) {
                count2 = T.charAt(j--) == '#' ? count2 + 1 : count2 - 1;
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            --i;
            --j;
        }

        return i == j;
    }
}
