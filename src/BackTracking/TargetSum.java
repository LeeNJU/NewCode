package BackTracking;

//题目描述:给定一个整数数组，一个整数S，对每一个整数加上加号或者减号，使得它们的和等于S，求有多少种
//解法描述:递归，每个元素有加号和减号两种可能

public class TargetSum {

    private int count = 0;

    private void dfs(int index, int[] nums, int s) {
        if (index >= nums.length) {
            if (s == 0) {
                ++count;
            }

            return;
        }

        dfs(index + 1, nums, s - nums[index]);
        dfs(index + 1, nums, s + nums[index]);
    }

    public int findTargetSumWays(int[] nums, int s) {
        dfs(0, nums, s);
        return count;
    }
}
