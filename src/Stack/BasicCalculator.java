package Stack;

import java.util.Stack;

//题目描述:给定一个字符串，包含加减乘除号，以及数字和空格，算出结果，例如"3+2*2"，结果为7
//解法描述:用栈遍历，保存前一个操作符

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        // 前一个操作符
        char sign = '+';
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ' ') {
                ++i;
                continue;
            }

            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    ++i;
                }

                if (sign == '+') {
                    stack.add(num);
                } else if (sign == '-') {
                    stack.add(-num);
                } else if (sign == '*') {
                    stack.add(stack.pop() * num);
                } else if (sign == '/') {
                    stack.add(stack.pop() / num);
                }

                // 更新操作符
                if (i < s.length()) {
                    sign = s.charAt(i);
                }
            } else {
                sign = s.charAt(i++);
            }
        }

        return stack.stream()
                .reduce((a, b) -> a + b)
                .orElse(0);
    }
}
