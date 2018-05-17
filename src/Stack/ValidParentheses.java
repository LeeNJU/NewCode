package Stack;

import java.util.Stack;

//题目描述:给定一个字符串，只包含([{)]}几种字符，判断是否是有效的字符串，即(),[],{}是有效的，(],([)]等都是
//        无效的
//解法描述:用一个栈把([[压入栈中，遇到)]}时，判断与栈顶元素是否相配
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }

            if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }

            if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
