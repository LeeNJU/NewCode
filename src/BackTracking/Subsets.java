package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目描述：给定一个整数集合，{1,2,3}，输出所有的子集，其中每个子集的元素以递增顺序，结果：{{3},{2},{1},{1,3},
//         {2,3},{1,2},{1,2,3},{}}，别忘了空集
//解法：递归，每一层递归加入一个元素到t中，并把t加入到result中

public class Subsets {

    private void dfs(List<Integer> list, List<List<Integer>> result, int index, int[] nums) {
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(list, result, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(list, result, 0, nums);
        return result;
    }

    // 题目描述：给定一个数组，包含重复元素，求出该数组的所有子集，子集中不能包含重复的子集， 例如[1,2,2],子集为[[2],[1],[1, 2, 2],[2, 2],[1, 2],[]]
    // 解法描述：递归，注意去掉重复元素

    private void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));

        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            dfs(i + 1, nums, list, result);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(0, nums, list, result);
        return result;
    }
}
