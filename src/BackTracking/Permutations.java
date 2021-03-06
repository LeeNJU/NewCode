package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目描述：给定一组数组，不包含重复元素，返回这组数组所有的组合情况。
//解法描述：递归回溯,用一个visited数组保存元素是否被访问过

public class Permutations {

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(nums, new ArrayList<Integer>(), result);
        return result;
    }

    // 包含重复元素
    // 先排序，用visited数组表示每个元素是否被访问过
    private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, visited, list, result);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(nums, visited, new ArrayList<Integer>(), result);

        return result;
    }
}
