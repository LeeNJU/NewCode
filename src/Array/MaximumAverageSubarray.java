package Array;

//题目描述:给定一个数组和一个值k，找到大小为k的子数组，使得平均数最小，例如Input: [1,12,-5,-6,50,3], k = 4，平均数最小的子数组是[12,-5,-6,50],平均值是12.75
//解法描述:遍历数组

public class MaximumAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }

            result = Math.max(result, sum);
            sum -= nums[i - k + 1];
        }

        return result / k;
    }
}
