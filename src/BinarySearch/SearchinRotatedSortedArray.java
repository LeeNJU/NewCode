package BinarySearch;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > nums[right]) {
                if (target >= nums[left]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target > nums[right]) {
                    right = middle - 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}
