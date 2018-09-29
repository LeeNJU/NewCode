package DynamicProgrammimg;

//题目描述:给定一个数字n，表示有n个数，1，2，3，..., n,用这些数字来组成bianry search tree,问总共有多少种唯一
//        的BST
//解法描述:动态规划，以i为根节点，1到i - 1为左子树，i + 1到n为右子节点，这样才能保证树的唯一性。
//         如果n = 0，dp[0] = 1,只有一种空树，dp[1] = 1,只有一个点，dp[2] = dp[0] * dp[2 - 1](1为根节点) +
//        dp[1] * dp[2 - 2](2为根节点)， dp[i] += dp[k - 1] * dp[i - k], 1 <= k <= i. dp[i]表示用i个数字
//        可以组成多少个BST，dp[k - 1]表示以k为根节点，用k - 1个数字能组成多少个BST，dp[i - k]表示用了k个数字
//        之后，还剩i - k个数字，能组成多少个BST

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int k = 1; k <= i; ++k) {
                dp[i] += dp[k - 1] * dp[i - k];
            }
        }

        return dp[n];
    }
}
