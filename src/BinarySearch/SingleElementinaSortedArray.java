package BinarySearch;

//题目描述:给定一个排好序的数组，只有一个元素出现一次，其余元素都出现两次，找到出现一次的元素，例如[1,1,2,3,3,4,4,8,8]，只出现一次的是2
//解法描述:二分，middle和middle + 1的元素进行比较，并且结合下标的位置

public class SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == nums[middle + 1]) {
                // 如果左边的元素都是两次，middle的下标应该是偶数
                if (middle % 2 == 0) {
                    left = middle + 2;
                } else {
                    right = middle - 1;
                }
            } else if (middle % 2 == 0) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }

        return nums[left];
    }
}
