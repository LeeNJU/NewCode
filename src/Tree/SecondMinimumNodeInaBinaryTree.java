package Tree;

import Util.TreeNode;

//题目描述: 给定一个二叉树，每个节点要么没有子节点，要么一定有两个子节点，如果有两个子节点，那么当前节点的值就是子节点值得最小值，找到这个树种倒数第二小的元素，如果没有，返回-1,例如
//              2
//             / \
//            2   5
//               / \
//              5   7
//        返回5
//解法描述:递归，根节点到叶子节点的路径一定是递增的

public class SecondMinimumNodeInaBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int right = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;

        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else {
            return Math.min(left, right);
        }
    }
}
