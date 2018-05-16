package BinarySearch;

//给定一个数组和一个target，从数组中找到target并返回其下标，如果数组中不存在target，则返回可以插入改元素的位置的下标
//解法：二分法查找结束后，如果找到该元素则成功返回，如果没有找到该元素，first指向该插入的位置
//该二分法结束后，first指向大于target的最小index，last指向小于target的最大index，例如array={1,3,5,6}中找2，二分结束后first指向3，last指向1

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
