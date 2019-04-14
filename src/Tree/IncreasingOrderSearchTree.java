package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，进行变换
//          5
//         / \
//        3    6
//       / \    \
//      2   4    8
//     /        / \
//    1        7   9   最后变成 1 - 2 - 3 - 4 - 5 - 6 -7 - 8 - 9
//解法描述:递归

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = increasingBST(root.right);
        if (root.left == null) {
            return root;
        }

        TreeNode newRoot = increasingBST(root.left);
        TreeNode node = newRoot;
        while (node.right != null) {
            node = node.right;
        }

        node.right = root;
        root.left = null;
        return newRoot;
    }
}
