package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到根节点到子节点的路径所代表的数字的和， 例如
//          1
//         / \
//        2   3  返回13 + 12 = 25
//解法描述:递归

public class SumRoottoLeafNumbers {

    private int sum = 0;

    private void dfs(TreeNode root, int prev) {
        if (root == null) {
            return;
        }

        prev = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += prev;
            return;
        }

        dfs(root.left, prev);
        dfs(root.right, prev);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}
