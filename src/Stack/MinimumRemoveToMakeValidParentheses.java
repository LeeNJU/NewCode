package Stack;

import java.util.Stack;

//题目描述:给定一个String,只包含小写字母和(),求出最少需要删除几个括号可以上整个string的括号都匹配,例如s = "a)b(c)d"，返回"ab(c)d"
//解法描述:因为需要恢复删除括号的String，所以需要记录被删除的括号的index，用stack遍历括号，记录不匹配的括号index

public class MinimumRemoveToMakeValidParentheses {

  public String minRemoveToMakeValid(String s) {
    boolean[] remove = new boolean[s.length()];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);

      if (c == '(') {
        stack.push(i);
      } else if (c == ')') {
        if (!stack.isEmpty()) {
          stack.pop();
        } else {
          remove[i] = true;
        }
      }
    }

    // stack里面的都是不匹配的(
    stack.stream().forEach(index -> remove[index] = true);

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      if (!remove[i]) {
        stringBuilder.append(s.charAt(i));
      }
    }

    return stringBuilder.toString();
  }
}
