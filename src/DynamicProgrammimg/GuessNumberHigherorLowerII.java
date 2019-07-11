package DynamicProgrammimg;

//题目描述:给定一个数字n，在1到n之间进行猜数游戏，每猜一个数字会给出高了还是低了的结果，直到最后猜中。但是每
//        猜错一次，就要给相应的钱，现在要求能够保重猜中的最少的钱数。例如1到10，正确数字是8，第一次猜5，低了
//        损失5，第二次猜7，低了，损失7， 第三次猜9，高了，损失9，第四次猜8，正确。最后一共付出5 + 7 + 9 = 21
//解法描述:动态规划，dp[i][j]表示要猜中区间[i,j]中的数字所需要的钱，遍历i到j中的所有可能性，例如猜k，有三种
//        情况，第一种猜中了，不用付钱，那么正确数字可能在[i, k - 1]或者[k + 1, j],那么猜k保证要赢的钱一共
//        是三种情况中的最大值，k + max(dp[i, k - 1], dp[k + 1, j])，对i到j中的每一个k进行遍历，取最小值。
//        dp[i][j] = min(dp[i][j], k + max(dp[i,k - 1], dp[k + 1, j])), i <= k <= j;

public class GuessNumberHigherorLowerII {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int length = 2; length < n + 1; ++length) {
            for (int i = 1; i < n + 1 && i + length - 1 < n + 1; ++i) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j; ++k) {
                    // 猜测的数字是k时，取三种情况的最大值才能保证赢
                    int money = 0;
                    if (k == i) {
                        money = k + dp[k + 1][j];
                    } else if (k == j) {
                        money = k + dp[i][k - 1];
                    } else {
                        money = Math.max(dp[i][k - 1], dp[k + 1][j]) + k;
                    }

                    // i到j中的最小值
                    dp[i][j] = Math.min(dp[i][j], money);
                }
            }
        }

        return dp[1][n];
    }
}
