package Tree;

import java.util.Stack;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，找到任意两个节点之间的最小差
//解法描述:中序遍历搜索树，找到相邻节点之间的最小差

public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        int result = Integer.MAX_VALUE;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (prev != null && node.val - prev.val < result) {
                result = node.val - prev.val;
            }
            prev = node;
            root = node.right;
        }

        return result;
    }
}
