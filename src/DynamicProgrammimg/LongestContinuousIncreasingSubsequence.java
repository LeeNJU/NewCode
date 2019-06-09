package DynamicProgrammimg;

//题目描述:给定一个整数数组，找到其中连续的最长递增或者递减序列，例如[5, 4, 2, 1, 3]，最长递减序列是5，4，2，1，返回4
//解法描述:dp,寻找连续的递增序列，遍历一遍就行

public class LongestContinuousIncreasingSubsequence {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int increaseCount = 1, decreaseCount = 1;
        int result = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > A[i - 1]) {
                ++increaseCount;
                result = Math.max(result, increaseCount);

                result = Math.max(result, decreaseCount);
                decreaseCount = 1;

            } else {
                result = Math.max(result, increaseCount);
                increaseCount = 1;

                ++decreaseCount;
                result = Math.max(result, decreaseCount);
            }
        }

        return result;
    }
}
