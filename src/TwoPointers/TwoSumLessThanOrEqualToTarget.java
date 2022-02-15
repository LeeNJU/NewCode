package TwoPointers;

import java.util.Arrays;

//题目描述:给定一个int数组和一个target,找到数组中两个元素之和小于等于target的个数,例如nums = [2, 7, 11, 15], target = 24,返回5,因为
//       2 + 7 < 24, 2 + 11 < 24, 2 + 15 < 24, 7 + 11 < 24, 7 + 15 < 24
//题目解法:先排序,然后首尾遍历

public class TwoSumLessThanOrEqualToTarget {

  public int twoSum5(int[] nums, int target) {
    Arrays.sort(nums);

    int result = 0;
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum > target) {
        --right;
      } else {
        result += (right - left);
        ++left;
      }
    }

    return result;
  }
}
