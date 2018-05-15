package Array;

//题目描述:nums，求出一个数组output，使得output[i]等于数组所有除了nums[i]之外的元素的乘积，不能用除法
//解法描述:数组result[i]表示nums[0]到nums[i - 1]的乘积，然后从右扫描，right记录nums[i]到nums[n - 1]的乘积，

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
