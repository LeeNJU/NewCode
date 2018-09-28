package BinarySearch;

//题目描述:给定一个升序数组和一个target值，找到target出现的第一次和最后一次的下标，例如nums = [5,7,7,8,8,10], target = 8，返回[3,4]
//解法描述:二分

public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        int[] result = new int[2];
        if (left >= nums.length || nums[left] != target) {
            result[0] = result[1] = -1;
            return result;
        }

        result[0] = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        result[1] = right;
        return result;
    }
}
