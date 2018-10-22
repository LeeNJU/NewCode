package Stack;

import java.util.Stack;

//题目描述：给定一个只包含()的字符串，找到最长的有效字符串，返回其长度，()为有效字符串
//解法描述:栈不为空表示前面有左括号，count的值代表前面有多少个左括号被匹配了

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int result = 0, count = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stk.push(count);
                count = 0;
            } else if (!stk.empty()) {
                count += (1 + stk.pop());
                result = Math.max(result, count);
            } else {
                count = 0;
            }
        }
        return result * 2;
    }
}