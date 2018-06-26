package Tree;

import java.util.Stack;

import Util.TreeNode;

//题目描述：给定一个二叉树，找到其中第k小的元素
//解法描述：中序遍历

public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        int result = -1;
        while (!stack.isEmpty()) {
            --k;
            node = stack.pop();
            result = node.val;
            if (k == 0) {
                break;
            }

            node = node.right;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }

        return result;
    }
}
