package Tree;

import java.util.Stack;

import Util.TreeNode;

//题目描述:给定一个树，判断是不是二叉搜索树
//解法描述:用栈进行中序遍历

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (prev != null && prev.val >= cur.val) {
                return false;
            }

            prev = cur;
            cur = cur.right;
        }

        return true;
    }
}
