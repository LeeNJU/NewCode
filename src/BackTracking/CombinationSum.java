package BackTracking;

import java.util.ArrayList;
import java.util.List;

//题目描述：给定一个值k和n，从1到9中求出和为n的组合，组合的大小为k，数字不能重复，例如：k=3，n=7，输出为
//         [[1,2,4]]
//解法描述：递归  0ms

public class CombinationSum {

    private void dfs(int start, int n, int k, int sum, List<Integer> intermediate, List<List<Integer>> result) {
        if (intermediate.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<Integer>(intermediate));
            }

            return;
        }

        for (int i = start; i < 10; ++i) {
            if (sum + i <= n) {
                intermediate.add(i);
                dfs(i + 1, n, k, sum + i, intermediate, result);
                intermediate.remove(intermediate.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> intermediate = new ArrayList<Integer>();
        dfs(1, n, k, 0, intermediate, result);

        return result;
    }
}
