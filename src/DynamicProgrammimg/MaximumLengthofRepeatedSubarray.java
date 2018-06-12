package DynamicProgrammimg;

//题目描述:给定两个数组A和B，找到最长的公共子数组，例如A: [1,2,3,2,1]，B: [3,2,1,4,7]，A和B共有的最长的子数组是[3, 2, 1],返回长度3
//解法描述:dp, 如果A[i] == B[j], dp[i][j] = dp[i - 1][j - 1] + 1, 否则dp[i][j] = 0, 由于只需要前一个元素，可以用一维数组倒序更新

public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int result = 0;
        int[] dp = new int[B.length + 1];

        for (int i = 0; i < A.length; ++i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    dp[j + 1] = dp[j] + 1;
                } else {
                    dp[j + 1] = 0;
                }

                result = Math.max(result, dp[j + 1]);
            }
        }

        return result;
    }
}
