package Stack;

import java.util.Stack;

//题目描述：给定一个只包含()的字符串，找到最长的有效字符串，返回其长度，()为有效字符串
//解法描述:用栈保存左括号的起始下标，start表示合法字符串的起始下标

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int result = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.isEmpty()) {
                start = i + 1;
            } else {
                stack.pop();
                result = stack.empty() ? Math.max(result, i - start + 1) : Math.max(result, i - stack.peek());
            }
        }

        return result;
    }
}
