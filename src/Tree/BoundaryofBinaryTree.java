package Tree;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到它的边界，左边界定义根节点出发，一直到最左边的节点的路径，右边界定义为从根节点出发，一直到最右边节点的路径，
//解法描述:递归，分别找到左边界，叶子节点和右边界，注意根节点的处理，如果只有一个根节点，既是边界节点又是叶子节点

public class BoundaryofBinaryTree {

    private void leaves(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }

        leaves(root.left, result);
        leaves(root.right, result);
    }

    private void leftBoundary(TreeNode root, List<Integer> result) {
        // 忽略null和叶子节点
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        result.add(root.val);
        if (root.left != null) {
            leftBoundary(root.left, result);
        } else {
            leftBoundary(root.right, result);
        }
    }

    private void rightBoundary(TreeNode root, List<Integer> result) {
        if (root == null || (root.right == null && root.left == null)) {
            return;
        }

        if (root.right != null) {
            rightBoundary(root.right, result);
        } else {
            rightBoundary(root.left, result);
        }

        result.add(root.val);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        if (root.left != null || root.right != null) {
            result.add(root.val);
        }

        leftBoundary(root.left, result);
        leaves(root, result);
        rightBoundary(root.right, result);
        return result;
    }
}
