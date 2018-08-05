package Array;

//题目描述：给定一个数组，每个元素表示能够向前跳跃的最大步数，求出能否跳跃到最后一个元素
//解法描述：贪心，记录当前元素能够跳跃的最远距离，判断最远距离是否大于数组长度

public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length && i <= maxReach; ++i) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
