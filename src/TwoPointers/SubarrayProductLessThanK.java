package TwoPointers;

//题目描述:给定一个正整数数组和一个值k，找到其中所有连续的子数组的个数，使得它们的乘积小于k，例如nums = [10, 5, 2, 6], k = 100，乘积小于100的连续的子数组有
//       [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6],返回8
//解法描述:双指针，[j, i]维护一个区间，这个区间的乘积小于k，区间的大小表示以i结尾的连续子数组的个数

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        int result = 0;
        int product = 1;
        for (int j = 0, i = 0; i < nums.length; ++i) {
            product *= nums[i];
            // 注意这里 j必须小于等于i
            while (product >= k && j <= i) {
                product /= nums[j++];
            }

            result += i - j + 1;
        }

        return result;
    }
}
