package DepthFirstSearch;

import java.util.Arrays;

//题目描述:给定一个数组以及一个k值，判断能不能把数组分成k个和一样的子数组，例如nums = [4, 3, 2, 3, 5, 2, 1], k = 4，可以分成4个子数组，(5), (1, 4), (2,3), (2,3)
//解法描述:递归，一组一组的找，终止条件是k == 1

public class PartitiontoKEqualSumSubsets {

    private boolean canPartition(int[] nums, int index, int target, int curSum, int k, boolean[] visited) {
        // k == 1,剩下的一组必然符合要求
        if (k == 1) {
            return true;
        }

        // 找到了一组解，继续找下一组，所以curSum从0开始
        if (target == curSum) {
            return canPartition(nums, 0, target, 0, k - 1, visited);
        }

        for (int i = index; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            if (canPartition(nums, i + 1, target, curSum + nums[i], k, visited)) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums)
                .sum();
        // 和必须能被k整除
        if (sum % k != 0 || k <= 0) {
            return false;
        }

        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, 0, sum / k, 0, k, visited);
    }
}
