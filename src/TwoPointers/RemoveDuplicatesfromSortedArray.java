package TwoPointers;

public class RemoveDuplicatesfromSortedArray {

    // 题目描述：给一个已序数组，删除其中的重复元素，使得每个元素只出现一次，并返回数组长度
    // 解法：index表示新下标，i=1开始遍历数组，如果A[index]不等于A[i]
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    // 版本二：给定一个已序数组，删除其中的重复元素，使得每个元素最多出现两次，并返回长度
    // 解法：与上题类似，加一个变量记录次数
    public int removeDuplicates2(int[] nums) {
        int index = 0, count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                ++count;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}
