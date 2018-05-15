package Array;

//题目描述：给定一个数组，将其中的元素右移k步，例如{1,2,3,4,5,6,7}右移3步后，{5,6，7,1,2,3,4}
//解法描述：做3次反转，[0,n-k-1]反转一次,[n-k,n-1]反转一次，[0,n-1]反转一次
public class RotateArray {

    private void rotate(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[right];
            nums[right] = nums[left];
            nums[left] = t;

            ++left;
            --right;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }

        k = k % nums.length;
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, 0, nums.length - 1);
    }
}
