package Array;

//题目描述：给定一个未排序的数组，从中找出第一个missing的正数，例如[3,4,-1,1]，那么第一个missing的正数是2。
//解法描述：思路就是把元素放入合适的位置，例如1放到0位置，2放到1位置...遍历数组，把元素都放到合适的位置，再遍历数组找到第一个没有放到合适位置的元素
public class FirstMissingPositive {

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
