package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

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

    // 题目描述：给定一个数组，判断是否存在元素A[i]和A[j]，使得i与j的差不超过k，A[i]与A[j]的差不超过t
    // 解法描述：用一个treeset保存i到j之间的元素，i和j的差不超过k，对于当前元素nums[i],找到它的upper bound和lower bound
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();

        for (int i = 0; i < nums.length; ++i) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            long n = (long) nums[i];
            Long ceiling = set.ceiling(n);
            Long floor = set.floor(n);
            if ((ceiling != null && ceiling - n <= t) || (floor != null && nums[i] - floor <= t)) {
                return true;
            }

            set.add(n);
        }

        return false;
    }
}
