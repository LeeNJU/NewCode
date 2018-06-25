package Array;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

    // 题目描述:给定一个数组，判断其中是否包含重复元素
    // 解法描述：用hashtable
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }

            hashSet.add(num);
        }

        return false;
    }

    // 题目描述：给定一个数组和一个值k，判断是否存在重复的元素，并且重复元素的下标之差不能超过k
    // 解法描述：sliding window的思路，用hashtset保存i到j之间的元素，i到j的差不超过k
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashMap.containsKey(nums[i]) && Math.abs(hashMap.get(nums[i]) - i) <= k) {
                return true;
            }

            hashMap.put(nums[i], i);
        }

        return false;
    }
}
