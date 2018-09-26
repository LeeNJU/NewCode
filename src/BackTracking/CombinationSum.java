package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
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

    // 题目描述:给定无重复数字的数组和一个target，找到所有数字的组合，使得他们的和等于target，每个数字可以重复使用
    // 解法描述:先排序

    private void dfs(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                dfs(candidates, i, target - candidates[i], list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        dfs(candidates, 0, target, list, result);
        return result;
    }

    // 题目描述:给定包含重复数字的数组和一个target，找到所有数字的组合，使得他们的和等于target，每个数字只能使用一次
    // 解法描述:先排序，注意去重
    private void dfs2(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }


        for (int i = index; i < candidates.length; ++i) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] <= target) {
                list.add(candidates[i]);
                dfs2(candidates, i + 1, target - candidates[i], list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        dfs2(candidates, 0, target, list, result);
        return result;
    }
}
