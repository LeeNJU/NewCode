package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个正整数数组，把元素分成两个集合，使得两个集合的和的差最小，例如nums = [1, 6, 11, 5]，分成[1,5,6]和[11]两个集合，他们的差是1
//解法描述:要使差最小，那么两个集合的和必须接近于数组和的一半，转换成背包问题，判断能不能用数组元素组成mid(数组和的一半),如果不能组成mid，就看mid - 1，etc

public class MinimumPartition {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = Arrays.stream(nums)
                .sum();
        int mid = sum / 2;
        boolean[] dp = new boolean[mid + 1];
        dp[0] = true;

        // 找到能不能用数组元素组成j
        for (int i = 0; i < nums.length; ++i) {
            for (int j = mid; j >= 0; j--) {
                dp[j] |= j - nums[i] >= 0 && dp[j - nums[i]];
            }
        }

        for (int i = mid; i >= 0; --i) {
            if (dp[i]) {
                return sum - i - i;
            }
        }

        return -1;
    }
}
