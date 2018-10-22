package Array;

//题目描述:给定一个数组，找到两个不重叠的子数组A和B，使得子数组A的和与子数组B的和的差最大，即|sum(A) - sum(B)|
//解法描述:尽量使A最大，B最小，但是不知道A在左边还是右边，如果A在左边，先找到最大的子数组和，然后从右向左扫描，
//        找到和最小的子数组，然后保存二者差的最大值，如果A在右边，那就要从左往右，先找到值最小的子数组，然后
//        从右往左扫描，得到和最大的子数组，同时保存二者之差的最大值

public class MaximumSubarrayDifference {

    public int maxDiffSubArrays(int[] nums) {
        int[] max_dp = new int[nums.length];
        int[] min_dp = new int[nums.length];

        max_dp[0] = min_dp[0] = nums[0];
        int max_local = nums[0];
        int min_local = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            max_local = Math.max(max_local + nums[i], nums[i]);
            max_dp[i] = Math.max(max_dp[i - 1], max_local);

            min_local = Math.min(min_local + nums[i], nums[i]);
            min_dp[i] = Math.min(min_dp[i - 1], min_local);
        }

        max_local = min_local = nums[nums.length - 1];
        int diff = Math.max(max_dp[nums.length - 2] - min_local, max_local - min_dp[nums.length - 2]);
        for (int i = nums.length - 2; i > 0; --i) {
            max_local = Math.max(max_local + nums[i], nums[i]);
            min_local = Math.min(min_local + nums[i], nums[i]);

            diff = Math.max(diff, Math.max(max_dp[i - 1] - min_local, max_local - min_dp[i - 1]));
        }

        return diff;
    }
}
