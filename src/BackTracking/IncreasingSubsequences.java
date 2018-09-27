package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//题目描述:给定一个数组，找到所有长度大于1的递增序列，例如[4, 6, 7, 7]，返回[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
//解法描述:dfs，不能改变数组元素的顺序，注意要用set去重

public class IncreasingSubsequences {

    private void dfs(int[] nums, int index, List<Integer> list, Set<List<Integer>> result) {
        if (list.size() > 1) {
            result.add(new ArrayList<Integer>(list));
        }

        for (int i = index; i < nums.length; ++i) {
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                dfs(nums, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result.stream()
                .collect(Collectors.toList());
    }
}
