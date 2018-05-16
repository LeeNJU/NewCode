package TwoPointers;

import java.util.Arrays;

//题目描述，给定一个数组，从中找出三个数，使它们的和与target最接近，即绝对值最小，返回三个数的和
//解法，先排序，然后用头尾两个指针向中间逼近，开始设置绝对值差值为INT_MAX，找到绝对值最小的和

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < diff) {
                    result = sum;
                    diff = Math.abs(sum - target);
                }

                // 控制下标的走向
                if (sum < target) {
                    ++left;
                } else if (sum > target) {
                    --right;
                } else {
                    return sum;
                }
            }
        }

        return result;
    }
}
