package Array;

//题目描述:给定一个环形数组，找到最大的子数组和，可以首尾相连，例如[5,-3,5]，最大和是[5,5],例如[-2,-3,-1],最大和是-1
//解法描述:如果最大的子数组和在数组之中，就和普通的最大子数组之和完全一样，如果最大子数组一半在前面，一半在后面(因为可以首尾相连)，那么位于中间的子数组的和一定是最小
//        最后的结果就是这两种情况的最大值，先按照普通的情况分别求出最大和最小的子数组和

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] A) {
        int totalSum = A[0];
        int maxSum = A[0];
        int minSum = A[0];
        int curMax = A[0];
        int curMin = A[0];
        for (int i = 1; i < A.length; ++i) {
            totalSum += A[i];

            curMax = Math.max(curMax + A[i], A[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + A[i], A[i]);
            minSum = Math.min(minSum, curMin);
        }

        // 注意这里，如果所有的元素都是负数，最大子数组和只能存在于数组中间
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
