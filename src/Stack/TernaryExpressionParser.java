package Stack;

import java.util.Stack;

//题目描述:给定一个三目表达式，返回最终的结果，例如 T ? 4 : 5,返回4，数字都是0到9的数字，T表示true，F表示
//        false，表达式可以嵌套，例如F ? 1 : T ? 4 : 5，返回4
//解法描述:用栈倒序遍历，每读到一个可以解析的合格的三目表达式就解析结果，把结果放回栈中

public class TernaryExpressionParser {

    public String parseTernary(String expression) {
        if (expression.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = expression.length() - 1; i >= 0; --i) {
            if (!stack.isEmpty() && stack.peek() == '?') // 碰到合格的三目表达式，计算结果，压入栈中
            {
                stack.pop(); // pop '?'
                Character first = stack.pop();
                stack.pop(); // pop ':'
                Character second = stack.pop();

                if (expression.charAt(i) == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(expression.charAt(i));
            }
        }

        return stack.pop()
                .toString();
    }
}
