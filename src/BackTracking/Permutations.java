package BackTracking;

import java.util.ArrayList;
import java.util.List;

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
}
