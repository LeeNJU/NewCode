package Sort;

//题目描述:给定一个数组和一个值k，partition数组，使得小于k的元素在左边，大于等于k的元素在右边，例如[3,2,2,1]，k=2，最后得到[1,2,2,3],返回第一个大于等于k的index
//解法描述:双指针，类似于quicksort

public class PartitionArray {

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int partitionArray(int[] nums, int k) {
        int index = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < k) {
                swap(nums, ++index, i);
            }
        }

        return index + 1;
    }
}
