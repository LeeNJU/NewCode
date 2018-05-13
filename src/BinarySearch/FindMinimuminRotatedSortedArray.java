package BinarySearch;

//题目描述:给定一个数组，该数组之前已排好序，但是在某一个点被调换了位置，例如4 5 6 7 0 1 2，找到其中的最小元素，假设数组中不包含重复元素
//解法描述:二分查找,判断middle落在哪个区域，上半区还是下半区

public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, middle;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }

    // 版本二：假设数组中包含重复元素
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1, middle;

        while (left < right) {
            // 两边两个元素相等，只需要移动left或right一个指针就可以了，不能两个都移动,例如[1,2,1]
            if (nums[right] == nums[left]) {
                --right;
                continue;
            }

            middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }
}
