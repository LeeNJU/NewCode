package Stack;

import java.util.Stack;

//题目描述:给定一个字符串，要求去除所有重复元素，使得每个元素只出现一次，并且最后的结果是字典序中最小的，例如
//        "bcabc"得到"abc"
//解法描述:用一个栈保存当前的最优解，如果当前元素比栈顶元素小，并且栈顶元素并不是最后一次出现，并且当前元素不在
//        栈中，那么弹出栈顶元素，加入当前元素
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        // 在栈中是否出现
        boolean[] visited = new boolean[26];
        // 统计每个字符的次数和已经出现的次数
        int[] count = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'a'];
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            // 当前字符比栈顶字符要小，并且栈顶字符并不是最后一次出现，并且当前字符不在栈中
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && count[stack.peek() - 'a'] > 0 && !visited[s.charAt(i) - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            --count[s.charAt(i) - 'a'];
            if (!visited[s.charAt(i) - 'a']) {
                visited[s.charAt(i) - 'a'] = true;
                stack.add(s.charAt(i));
            }
        }

        return stack.stream()
                .map(c -> Character.toString(c))
                .reduce((a, b) -> a + b)
                .orElse("");
    }
}
