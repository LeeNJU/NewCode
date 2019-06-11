package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一个非负元素的数组，每个元素可以选择加号或者减号，求多少种方式，可以使得整个数组的和等于给定元素target，例如[1, 1, 1, 1, 1]，S = 3，总共有5种方式
//       -1+1+1+1+1 = 3     +1-1+1+1+1 = 3    +1+1-1+1+1 = 3  +1+1+1-1+1 = 3   +1+1+1+1-1 = 3
//解法描述:本质上是要找到两个集合P和N，集合P中的元素都分给加号，集合N中的元素都分给减号，那么有如下关系
//                         sum(P) - sum(N) = target
//       sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                              2 * sum(P) = target + sum(nums)
//       题目可以转换成背包问题，在数组中找到某些元素，使得他们的和是(target + sum(nums)) / 2

public class TargetSum {

    private int findSubset(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = target; j >= nums[i]; --j) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums)
                .sum();

        if (sum < S || (S + sum) % 2 == 1) {
            return 0;
        }

        return findSubset(nums, (S + sum) / 2);
    }
}
