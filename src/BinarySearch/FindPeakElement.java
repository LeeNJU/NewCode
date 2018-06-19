package BinarySearch;

//题目描述：给定一个数组，其中相邻元素不等，找到一个peak element，使它比左右相邻的两个元素都大，假设n[0]和n[n]都等于负无穷
//解法描述：二分查找，缩小peak元素的范围

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
