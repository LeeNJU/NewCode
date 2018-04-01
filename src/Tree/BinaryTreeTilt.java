package Tree;

import Util.TreeNode;

//思路: 递归，找到左右子树元素的和，计算当前节点的tilt value，累计到全局变量中。

public class BinaryTreeTilt {

    private int sum = 0;

    private int findTiltValue(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_sum = findTiltValue(root.left);
        int right_sum = findTiltValue(root.right);
        int tilt = Math.abs(left_sum - right_sum);
        sum += tilt;
        return left_sum + right_sum + root.val;
    }

    public int findTilt(TreeNode root) {
        findTiltValue(root);
        return sum;
    }
}
