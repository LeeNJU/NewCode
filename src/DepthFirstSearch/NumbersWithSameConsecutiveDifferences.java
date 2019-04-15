package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//题目描述:给定一个数N和K，N代表n位数，找到所有的n位数，使得每一位的差都是k，例如N = 3, K = 7，返回[181,292,707,818,929]
//解法描述:递归，注意处理特殊情况，例如k = 0

public class NumbersWithSameConsecutiveDifferences {

    private void dfs(int n, int num, int k, List<Integer> list) {
        if (n == 0) {
            list.add(num);
            return;
        }

        int prev = num % 10;
        if (prev + k < 10) {
            dfs(n - 1, num * 10 + prev + k, k, list);
        }

        // 处理k = 0的情况
        if (prev - k >= 0 && k != 0) {
            dfs(n - 1, num * 10 + prev - k, k, list);
        }
    }

    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> list = new ArrayList<>();
        // 处理0的情况
        if (N == 1) {
            list.add(0);
        }

        IntStream.rangeClosed(1, 9)
                .forEach(index -> dfs(N - 1, index, K, list));

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
