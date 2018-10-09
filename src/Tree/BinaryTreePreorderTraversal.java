package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Util.TreeNode;

//题目描述:二叉树的先序遍历
//解法描述:用栈，先加入右子节点，再加入左子节点

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return list;
    }
}
