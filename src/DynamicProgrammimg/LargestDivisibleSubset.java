package DynamicProgrammimg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目描述:给定一个无重复数字的数组，找到最大的集合，使得没两个元素都可以整除，例如[1,2,3]，返回[1,2]或者[1,3]
//解法描述:dp求出最大的集合大小，然后重新构建集合，需要记录前一个元素的下标

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 1) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        int[] prev = new int[nums.length];
        int[] dp = new int[nums.length];

        int length = 1;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            prev[i] = i;

            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > length) {
                length = dp[i];
                index = i;
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        while (prev[index] != index) {
            list.add(nums[index]);
            index = prev[index];
        }
        list.add(nums[index]);

        return list;
    }
}
