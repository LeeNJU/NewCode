package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定一组pair,(a, b), (c, d),只能当b小于c的时候，这两个pair才能形成一个连续的chain，求这样的chain的最大长度，例如[[1,2], [2,3], [3,4]]，最大的chain的长度是2，
//         [1,2] -> [3,4]
//解法描述:dp,跟longest increasing subsequence一样，先排序，dp[i] = max(dp[i], dp[j] + 1) if 第j个元素能够和第i个元素形成一个chain

public class MaximumLengthofPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int result = 0;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
