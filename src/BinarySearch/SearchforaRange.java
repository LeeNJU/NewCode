package BinarySearch;

//题目描述:给定一个已序数组和一个值，从中找出这个值在数组的范围，用下标表示，如果该值不存在，则返回2个-1
//解法描述:二分法，用lower_bound和upper_bound

public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int left = 0, right = nums.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        // 注意这里，要判断下表是否有效，因为right一直向左移动，可能变成负数
        // 同理，如果是检查left，left可能会大于n
        if (right < 0 || nums[right] != target) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        result[1] = right;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        result[0] = left;
        return result;
    }
}
