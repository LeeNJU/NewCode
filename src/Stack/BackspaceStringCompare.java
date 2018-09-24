package Stack;

import java.util.Stack;

//题目描述:给定两个字符串S和T，只包含小写字母和#，#代表后退一格，判断两个字符串是否相等，例如S = "ab#c", T = "ad#c"，返回true
//解法描述:栈

public class BackspaceStringCompare {

    private String convert(final String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == '#' && !stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack.stream()
                .map(a -> a.toString())
                .reduce((a, b) -> a + b)
                .orElse("");
    }

    public boolean backspaceCompare(String S, String T) {
        return convert(S).equals(convert(T));
    }
}
