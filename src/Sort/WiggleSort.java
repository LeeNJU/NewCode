package Sort;

//题目描述:给定一个未排序数组，重组数组使得满足下面规律:num[0]<=num[1]>=num[2]<=num[3]...
//解法描述:扫描一遍，如果当前元素不满足规律，就与前一个元素交换，交换num[i]和num[i - 1]

public class WiggleSort {

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }
}
