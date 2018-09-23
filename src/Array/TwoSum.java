package Array;

import java.util.HashMap;
import java.util.Map;

//题目描述：给定一个数组，从中间找出2个数使其加起来等于指定的一个数，例如array={2,9,33,1}找出和等于11的2个数
//解法：用unordered_map存每个数的下标，时间复杂度为O(n)

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }

        return result;
    }
}
