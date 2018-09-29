package DynamicProgrammimg;

//题目描述:给定一个数字n，表示有n个数，1，2，3，..., n,用这些数字来组成bianry search tree,问总共有多少种唯一
//        的BST
//解法描述:动态规划，以i为根节点，1到i - 1为左子树，i + 1到n为右子节点，这样才能保证树的唯一性。
//         如果n = 0，dp[0] = 1,只有一种空树，dp[1] = 1,只有一个点，dp[2] = dp[0] * dp[2 - 1](1为根节点) +
//        dp[1] * dp[2 - 2](2为根节点)， dp[i] += dp[k - 1] * dp[i - k], 1 <= k <= i. dp[i]表示用i个数字
//        可以组成多少个BST，dp[k - 1]表示以k为根节点，用k - 1个数字能组成多少个BST，dp[i - k]表示用了k个数字
//        之后，还剩i - k个数字，能组成多少个BST

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

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

    // 要求输出所有可能的BST
    // 解法描述:递归，genTree表示产生所有以i为根节点的树，start <= i <= end
    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, end);

            for (int j = 0; j < left.size(); ++j) {
                for (int k = 0; k < right.size(); ++k) {
                    TreeNode node = new TreeNode(i);
                    node.left = left.get(j);
                    node.right = right.get(k);
                    list.add(node);
                }
            }
        }

        return list;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }
}
