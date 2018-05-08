package DynamicProgrammimg;

//题目描述:给定一个正数，没有重复的数组和一个target，找到有多少种组合的方式，使得元素的和等于target，一个元素可以选择多次，元素的顺序不同也算作不同的组合，例如
//        nums = [1, 2, 4], target = 4，[1, 1, 1, 1]，[1, 1, 2]，[1, 2, 1]，[2, 1, 1]，[2, 2]，[4]返回6
//解法描述:dp,类似于背包，不同的是，必须从target作为外循环遍历，这样可以考虑元素的顺序(仔细体会)

public class CombinationSumIV {

    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; ++i) {
            for (int val : nums) {
                if (i >= val) {
                    dp[i] += dp[i - val];
                }
            }
        }

        return dp[target];
    }
}
