package DynamicProgrammimg;

//题目描述:给定一个数组，找到两个长度为L和M的子数组，使得他们的和最大，L子数组可能在M子数组前面或者后面，例如A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
//       最大和来自[9]和[6,5] 
//解法描述:dp,和买卖股票2的思路一样

public class MaximumSumofTwoNonOverlappingSubarrays {

    private int maxSum(int[] A, int L, int M) {
        int[] dp = new int[A.length + 1];
        dp[0] = L == 1 ? A[0] : 0;

        int sum = 0;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            if (i > L - 1) {
                sum -= A[i - L];
            }

            if (i >= L - 1) {
                dp[i + 1] = Math.max(dp[i], sum);
            } else {
                dp[i + 1] = 0;
            }
        }

        int max = 0;
        sum = 0;
        int result = 0;
        for (int i = A.length - 1; i >= L; --i) {
            sum += A[i];
            if (i < A.length - M) {
                sum -= A[i + M];
            }

            if (i <= A.length - M) {
                max = Math.max(max, sum);
            } else {
                max = 0;
            }

            result = Math.max(result, max + dp[i]);
        }

        return result;
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(maxSum(A, L, M), maxSum(A, M, L));
    }
}
