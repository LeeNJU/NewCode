package TwoPointers;

//题目描述:给定一个正整数数组和一个正整数s，从数组中找到和大于等于s的最小子数组的长度,例如[2,3,1,2,4,3]和
//         s = 7，最小长度为[4,3]
//解法描述:用left和right两个指针维护这个子数组，sum为子数组的和，向右移动right，直到sum大于等于s，然后循环
//        去除子数组的左边部分
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0, size = Integer.MAX_VALUE;
        for (int i = 0, j = 0; j < nums.length; ++j) {
            sum += nums[j];

            while (sum >= s) {
                size = Math.min(size, j - i + 1);
                sum -= nums[i];
                ++i;
            }
        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }
}
