package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，把它扁平化，使得每一个节点都连接到右节点
//解法描述:可以用递归，先扁平左子树，然后扁平右子树，进行连接，非递归解法是，找到左子树的最右边的节点，把根节点的右子节点连接到这个节点上，然后左子树移到右子树，循环进行

public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left != null) {
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }

                left.right = root.right;
                root.right = root.left;
                root.left = null;

            }

            root = root.right;
        }
    }
}
