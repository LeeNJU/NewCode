package Stack;

import java.util.Stack;

//题目描述:没有括号，支持加减乘除，例如" 3+5 / 2 "返回5
//解法描述:记录每个数字的符号，把数字放入栈中，如果是乘号或者除号，重新运算，然后放入栈中

public class BasicCaculatorII {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '+') {
                sign = '+';
            } else if (c == '-') {
                sign = '-';
            } else if (c == '*') {
                sign = '*';
            } else if (c == '/') {
                sign = '/';
            } else if (Character.isDigit(c)) {
                int number = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + s.charAt(i) - '0';
                    ++i;
                }

                --i;
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
            }
        }

        return stack.stream()
                .reduce((a, b) -> a + b)
                .orElse(0);
    }
}
