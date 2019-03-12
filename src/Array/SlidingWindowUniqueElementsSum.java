package Array;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个整数数组和一个sliding window，大小为k，求出每个sliding window里面次数为1的元素的次数之和，例如[1, 2, 1, 3, 3],k = 3, First window [1, 2, 1],
//        only 2 is unique, count is 1. Second window [2, 1, 3], all elements unique, count is 3. Third window [1, 3, 3], only 1 is unique,
//        count is 1. sum of count = 1 + 3 + 1 = 5
//解法描述:hashmap保存window之中元素的出现次数，

public class SlidingWindowUniqueElementsSum {

    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // 加入当前元素之后，unique元素的个数可能会变
            if (map.get(nums[i]) == 1) {
                ++count;
            } else if (map.get(nums[i]) == 2) {
                --count;
            }

            if (i < k - 1) {
                continue;
            }

            sum += count;
            map.put(nums[i - k + 1], map.get(nums[i - k + 1]) - 1);
            // 删除元素之后，unique的元素个数可能也会变
            if (map.get(nums[i - k + 1]) == 0) {
                --count;
                map.remove(nums[i - k + 1]);
            } else if (map.get(nums[i - k + 1]) == 1) {
                ++count;
            }
        }

        // 最后考虑k比数组大的情况
        return nums.length < k ? count : sum;
    }
}
