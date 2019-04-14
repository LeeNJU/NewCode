package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述:给定一个字符串，只包含数字，把它划分成Fibonacci数列，例如"123456579"，划分成[123,456,579]，例如"11235813"，划分成[1,1,2,3,5,8,13]，每个数字不能是0开头，除非数字是0
//解法描述:递归穷举，递归的每一步加入一个数字

public class SplitArrayintoFibonacciSequence {

    private void dfs(String s, int index, List<Integer> list, List<Integer> result) {
        if (index >= s.length()) {
            if (list.size() >= 3 && result.isEmpty()) {
                result.addAll(list);
            }

            return;
        }

        for (int i = index; i < s.length(); ++i) {
            String num = s.substring(index, i + 1);
            long value = Long.parseLong(num);
            // invalid的数字
            if (num.charAt(0) == '0' && num.length() > 1 || value > Integer.MAX_VALUE) {
                break;
            }

            int n = list.size();
            if (n >= 2 && list.get(n - 1) + list.get(n - 2) != value) {
                continue;
            }

            list.add((int) value);
            dfs(s, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(S, 0, list, result);
        return result;
    }
}
