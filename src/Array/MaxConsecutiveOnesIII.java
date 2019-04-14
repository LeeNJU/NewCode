package Array;

//题目描述:给定一个数组，只包含0和1，最多允许把k个0变成1，求问最长的连续的1的长度，例如A = [1,1,1,0,0,0,1,1,1,1,0], K = 2，返回6，[1,1,1,0,0,1,1,1,1,1,1]
//解法描述:sliding window,表示window中有多少个0，因为肯定是要把连续的0变成1，所以本质上是遍历k个0的组合

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        int left = 0;
        int zeros = 0;
        int length = 0;
        for (int right = 0; right < A.length; ++right) {
            if (A[right] == 0) {
                ++zeros;
            }

            // sliding window中0的个数超过k
            while (zeros > K) {
                if (A[left++] == 0) {
                    --zeros;
                }
            }

            length = Math.max(length, right - left + 1);
        }

        return length;
    }
}
