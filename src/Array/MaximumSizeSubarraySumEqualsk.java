package Array;

import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个数组和一个k值，找到嘴馋的连续子数组，使得子数组的和是k，例如nums = [1, -1, 5, -2, 3], k = 3，最长的子数组是[1, -1, 5, -2],返回4
//解法描述:hashmap保存sum出现的下标

public class MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 处理[0, i]区间满足条件的情况
        map.put(0, -1);
        int sum = 0;
        int length = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                length = Math.max(length, i - map.get(sum - k));
            }

            // 为了保证最大的长度，只保存sum第一次出现的下标
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return length;
    }
}
