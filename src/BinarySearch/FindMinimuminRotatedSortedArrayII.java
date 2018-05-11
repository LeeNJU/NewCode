package BinarySearch;

//版本二：假设数组中包含重复元素
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
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
