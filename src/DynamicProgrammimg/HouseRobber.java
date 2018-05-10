package DynamicProgrammimg;

//题目描述：给定一个整数数组代表每个家庭的钱，现在去抢劫，但是不能抢劫相连的两家，求最大能抢劫多少钱
//解法描述：动态规划  dp[i] = max(dp[i - 1], dp[i - 2] + n[i]),由于只需要前面两个值，可以优化成常数空间

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int f1 = nums[0];
        int f2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; ++i) {
            int f3 = Math.max(f1 + nums[i], f2);

            f1 = f2;
            f2 = f3;
        }

        return f2;
    }
}
