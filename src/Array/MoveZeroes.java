package Array;

//题目描述：给定一个数组，其中包含若干个0，要求把所有的0放到数组末尾，并且保持非0元素的相对顺序不变
//解法描述：双指针遍历数组，碰到一个非0元素，与前面的元素交换

public class MoveZeroes {

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void moveZeroes(int[] nums) {
        for (int j = -1, i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                swap(nums, ++j, i);
            }
        }
    }
}
