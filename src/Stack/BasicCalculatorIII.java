package Stack;

import java.util.Stack;

//题目描述:支持加减乘除以及括号，例如" 6-4 / (2 * (3+1)) "，返回6
//解法描述:对括号内的进行递归，剩下的本质上和basic calculatorii 一样

public class BasicCalculatorIII {

    private int find(String s, int i) {
        int count = 0;
        for (; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++count;
            } else if (s.charAt(i) == ')') {
                --count;
                if (count == 0) {
                    return i;
                }
            }
        }

        return count;
    }

    private void addToStack(Stack<Integer> stack, char sign, int number) {
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

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int number = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + s.charAt(i) - '0';
                    ++i;
                }

                --i;
                addToStack(stack, sign, number);
            } else if (c == '(') {
                int index = find(s, i);
                addToStack(stack, sign, calculate(s.substring(i + 1, index)));
                i = index;
            } else if (c == '+') {
                sign = '+';
            } else if (c == '-') {
                sign = '-';
            } else if (c == '*') {
                sign = '*';
            } else if (c == '/') {
                sign = '/';
            }
        }

        return stack.stream()
                .reduce((a, b) -> a + b)
                .orElse(0);
    }
}
