package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Util.TreeNode;

//思路: 把所有左子节点放入栈中，遍历栈中元素，如果节点有右子节点，就把全部左子节点放入栈中。

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
