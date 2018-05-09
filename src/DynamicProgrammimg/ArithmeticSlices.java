package DynamicProgrammimg;

//题目描述:给定一个数字序列，找到其中的等差数列，返回总共有多少种这样的等差数列，例如1, 2, 3, 4，总共有[1,2,3],[2,3,4],[1,2,3,4]3中等差序列
//解法描述:dp, dp[i]表示以当前数字结尾的等差序列的长度，那么dp[i] = dp[i - 1] + 1,所以只需要保存前一个结果，遍历数组更新dp[i]，然后求和

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        int result = 0, cur = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                ++cur;
                result += cur;
            } else {
                cur = 0;
            }
        }

        return result;
    }
}
