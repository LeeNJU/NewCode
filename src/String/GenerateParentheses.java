package String;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个数字n，表示有n个左括号和n个右括号，输出所有的符合条件的字符串，例如n = 3，输出["((()))", "(()())", "(())()", "()(())", "()()()"]
//解法描述:递归，在每一步选择需要放左括号还是右括号，只有当右括号数量大于左括号数量的时候，才可以放右括号

public class GenerateParentheses {

    private void dfs(String s, int left, int right, int n, List<String> result) {
        if (s.length() == n) {
            result.add(s);
            return;
        }

        if (left > 0) {
            dfs(s + "(", left - 1, right, n, result);
        }

        if (right > left) {
            dfs(s + ")", left, right - 1, n, result);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, n * 2, result);
        return result;
    }
}
