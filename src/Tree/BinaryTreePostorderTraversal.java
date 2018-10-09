package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Util.TreeNode;

//题目描述:二叉树后序遍历
//解法描述:跟先序遍历完全相反

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 注意这里
            list.addFirst(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return list;
    }
}
