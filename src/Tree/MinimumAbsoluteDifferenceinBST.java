package Tree;

import java.util.Stack;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，找到相邻元素之间差的最小值
//解法描述:中序遍历

public class MinimumAbsoluteDifferenceinBST {

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int diff = Integer.MAX_VALUE;
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (prev != null && node.val - prev.val < diff) {
                diff = node.val - prev.val;
            }

            prev = node;
            root = node.right;
        }

        return diff;
    }
}
