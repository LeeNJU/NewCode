package BinarySearch;

//题目描述:给定一个已序数组，但是该数组在某一个位置被反转了，在该数组中查找指定的元素，例如array={4,5,6,1,2,3}查找2
//解法描述:二分法, middle和right的先进行比较

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > nums[right]) {
                if (nums[middle] > target && target >= nums[left]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] < target && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}
