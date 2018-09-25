package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目描述:给定一个数组，找到所有的三个数的组合，使得她们的和等于0，例如nums = [-1, 0, 1, 2, -1, -4],返回[ [-1, 0, 1], [-1, -1, 2] ]
//解法描述:先排序，注意去重

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    ++left;
                    continue;
                }

                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    --right;
                    continue;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    ++left;
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return result;
    }
}
