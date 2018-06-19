package BackTracking;

import java.util.ArrayList;
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
}
