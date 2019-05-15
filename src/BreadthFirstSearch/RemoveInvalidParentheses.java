package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//题目描述:给定一个字符串，包含()和字母，去除字符串中的非法括号，使得整个字符串中的括号能够相互匹配，例如
//        "()())()",去掉括号,得到["()()()", "(())()"]，要求去掉的括号最少，返回所有可能的结果
//解法描述:广度搜索，对每一个(或者)，去掉该括号，然后判断剩下的字符串是否合法，先只去掉一个括号，如果没有合法字符串，然后去掉2个括号。

public class RemoveInvalidParentheses {

    private boolean isValid(String s) {
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

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(s);
        HashSet<String> set = new HashSet<String>();
        set.add(s);
        boolean found = false;

        List<String> result = new ArrayList<String>();

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (isValid(str)) {
                found = true;
                result.add(str);
                continue;
            }

            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }

                String string = str.substring(0, i) + str.substring(i + 1);
                if (!found && !set.contains(string)) {
                    queue.add(string);
                    set.add(string);
                }
            }
        }

        return result;
    }
}
