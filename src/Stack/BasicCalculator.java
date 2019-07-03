package Stack;

import java.util.Stack;

//题目描述:给定一个字符串，包含数字，加减号和括号，算出正确的值，例如"(1+(4+5+2)-3)+(6+8)"，返回23
//解法描述:遍历字符串，由于有括号的存在，会导致每个数字的符号会发生改变，用stack保存当前括号外的符号，

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        stack.push(sign);

        int number = 0;
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            } else if (c == '+' || c == '-') {
                result += sign * number;
                number = 0;
                sign = stack.peek() * (c == '+' ? 1 : -1);
            }
        }

        // 最后一个数字
        result += sign * number;
        return result;
    }
}
