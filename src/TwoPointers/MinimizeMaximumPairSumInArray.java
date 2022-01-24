package TwoPointers;

import java.util.Arrays;

//题目描述:给定一个数组，数组长度为偶数，pair sum定义为两个元素的和，重新排列数组，使得最大的pair sum最小，例如nums = [3,5,4,2,4,6]，可以分成
//       pairs (3,5), (4,4), and (6,2)，这样最小的pair sum是8
//解法:先排序,第i个元素和第n - i - 1个元素组成一个pair，找到pair sum的最大值

public class MinimizeMaximumPairSumInArray {

  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    int n = nums.length;

    for(int i = 0; i < n / 2; ++i) {
      result = Math.max(nums[i] + nums[n - i - 1], result);
    }

    return result;
  }
}