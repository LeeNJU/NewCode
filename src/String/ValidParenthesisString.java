package String;

//题目描述:给定一个字符串，只包含(,)和*，其中*可以表示(或者)或者空字符串，判断该字符串是否匹配
//解法描述:扫描两边，第一遍把*当成(，第二遍把*当成)

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                ++counter;
            } else {
                --counter;
            }

            if (counter < 0) {
                return false;
            }
        }

        counter = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                ++counter;
            } else {
                --counter;
            }

            if (counter < 0) {
                return false;
            }
        }

        return true;
    }
}
