package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到所有节点tilt值，tilt值定义为左子树元素的和，与右子树元素的和，二者之差的绝对值
//解题思路: 递归，找到左右子树元素的和，计算当前节点的tilt value，累计到全局变量中。

public class BinaryTreeTilt {

    private int sum = 0;

    private int dfs(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_sum = dfs(root.left);
        int right_sum = dfs(root.right);
        int tilt = Math.abs(left_sum - right_sum);
        sum += tilt;
        return left_sum + right_sum + root.val;
    }

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }
}
