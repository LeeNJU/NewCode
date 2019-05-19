package DynamicProgrammimg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//题目描述:给定一个数组，每个元素都是唯一并且大于1的，用这些元素构造二叉树，使得每个节点的值等于左右子节点的乘积，例如A = [2, 4, 5, 10],可以得到
//       [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2],求总共可以组成多少个二叉树，结果模modulo 10 ** 9 + 7.
//解法描述:dp,dp[i]表示i做根节点的二叉树的个数，然后遍历[0,i]的元素作为左子节点

public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] A) {
        long mod = (long) Math.pow(10, 9) + 7;
        // 用hashmap来保存，可以快速找到另一个子节点是否存在以及对应的值
        Map<Integer, Long> dp = new HashMap<Integer, Long>();
        Arrays.sort(A);
        for (int i = 0; i < A.length; ++i) {
            dp.putIfAbsent(A[i], 1L);
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0 && dp.containsKey(A[i] / A[j])) {
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.get(A[i] / A[j])) % mod);
                }
            }
        }

        return (int) (dp.keySet()
                .stream()
                .map(key -> dp.get(key))
                .reduce((a, b) -> a + b)
                .orElse(0L)
                .longValue() % mod);
    }
}
