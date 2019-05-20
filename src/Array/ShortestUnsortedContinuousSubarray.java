package Array;

//题目描述:给定一个整数数组，可能有重复元素，找到最短的连续子数组，排序之后，使得整个数组是升序排列，例如[2, 6, 4, 8, 10, 9, 15]，只需要把
//        [6, 4, 8, 10, 9]排序，就使得整个数组升序，返回子数组长度为5
//解法描述:找到连续子数组的起始和终止index，正向遍历找到end，逆向遍历找到start，end逐渐变大，start逐渐变小，最后要注意数组本身已经有序的情况

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[n - 1];
        int start = -1, end = -2;
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);

            // 当前元素比max小，说明这个位置需要重新排序
            if (nums[i] < max) {
                end = i;
            }

            // 当前元素比min小，说明这个位置需要重新排序
            if (nums[n - i - 1] > min) {
                start = n - i - 1;
            }
        }

        return end - start + 1;
    }
}
