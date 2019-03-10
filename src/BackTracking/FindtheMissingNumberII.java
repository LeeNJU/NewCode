package BackTracking;

import java.util.HashSet;
import java.util.Set;

//题目描述:给定一个数字n，代表1到n个数字，这些数字组成一个字符串，但是缺少一个数字，找到缺少的那个数字，例如n = 20 and str = 19201234567891011121314151618，返回17
//解法描述:dfs穷举，对于递归的每一步，可以选择一位数字，也可以选择两位数字

public class FindtheMissingNumberII {

    private int result = -1;

    private void dfs(int index, String str, Set<Integer> set, int n) {
        if (index >= str.length()) {
            // set的大小必须是n - 1
            if (set.size() != n - 1) {
                return;
            }

            for (int i = 1; i <= n; ++i) {
                if (!set.contains(i)) {
                    result = i;
                    break;
                }
            }

            return;
        }

        // 以0开头的数字是invalid
        if (str.charAt(index) == '0') {
            return;
        }

        int num = 0;
        for (int i = index; i < index + 2 && i < str.length(); ++i) {
            num = num * 10 + str.charAt(i) - '0';
            if (!set.contains(num) && num <= n && num > 0) {
                set.add(num);
                dfs(i + 1, str, set, n);
                set.remove(num);
            }
        }
    }

    public int findMissing2(int n, String str) {
        Set<Integer> set = new HashSet<Integer>();
        dfs(0, str, set, n);
        return result;
    }
}
