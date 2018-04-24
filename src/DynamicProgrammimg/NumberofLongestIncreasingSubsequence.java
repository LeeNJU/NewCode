package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定要给未排序的数组，找到最长子序列的长度，找到有多少个最长的子序列，例如[1,3,5,4,7]，最长子序列有两个1, 3, 4, 7] and [1, 3, 5, 7]，返回2
//解法描述:dp, length数组表示以nums[i]结尾的子序列的最大长度，count数组表示以nums[i]结尾的最长子序列的个数

public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int result = 0, maxLength = 0;

        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (length[i] == length[j] + 1)
                        count[i] += count[j];

                    if (length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                }
            }

            if (maxLength == length[i]) {
                result += count[i];
            }

            if (maxLength < length[i]) {
                maxLength = length[i];
                result = count[i];
            }
        }
        return result;
    }
}
