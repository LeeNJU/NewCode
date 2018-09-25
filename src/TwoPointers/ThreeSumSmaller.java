package TwoPointers;

import java.util.Arrays;

//题目描述:给定一个数组，找到所有的三个数的组合，使得她们的和等于0，例如nums = [-1, 0, 1, 2, -1, -4],返回[ [-1, 0, 1], [-1, -1, 2] ]
//解法描述:先排序，不需要去重
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    result += right - left;
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return result;
    }
}
