package DynamicProgrammimg;

//题目描述:给定一个数组和K，把数组划分成多个连续的子数组，子数组长度不能超过K，把每一个子数组的元素都改成子数组的最大元素，得到数组的和，在所有可能的划分方式中，
//        求最大的和，例如A = [1,15,7,9,2,5,10], K = 3，[15,15,15,9,10,10,10]，返回84
//解法描述:dp[i]表示[0,i]的元素按照要求进行划分得到的最大和，dp[i] = max(dp[i], dp[j] + max * (i - j + 1)), max是(j, i)的最大值

public class PartitionArrayforMaximumSum {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length + 1];

        for (int i = 0; i < A.length; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j > i - K && j >= 0; --j) {
                max = Math.max(max, A[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + max * (i - j + 1));
            }
        }

        return dp[A.length];
    }
}
