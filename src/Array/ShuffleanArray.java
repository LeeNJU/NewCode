package Array;

import java.util.Random;

//题目描述:给定一个数组，对其进行打乱重排，使得每一种排列的可能性都是相同的。
//解法描述:采用随机数发生器，对第i个位置的元素，产生一个随机下标，得到这个位置的元素，i加1，随机数的范围随之减小。

public class ShuffleanArray {

    private int[] nums;
    private Random random;

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] result = this.nums.clone();

        for (int i = 0; i < result.length; ++i) {
            int index = random.nextInt(result.length - i) % (result.length - i);
            swap(result, i, index + i);
        }

        return result;
    }
}
