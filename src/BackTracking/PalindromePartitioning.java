package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述：给定一个字符串，划分该字符串，使得每一个子串都是palindrome，返回所有可能的结果
//解法描述：类似于深搜，递归调用

public class PalindromePartitioning {

    private boolean isPalindrome(final String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }

        return i >= j;
    }

    private void dfs(final String s, int index, List<String> list, List<List<String>> result) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                final String str = s.substring(index, i + 1);
                list.add(str);
                dfs(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(s, 0, new ArrayList<String>(), result);
        return result;
    }
}
