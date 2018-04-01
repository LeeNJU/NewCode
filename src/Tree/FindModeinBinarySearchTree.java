package Tree;

import java.util.Stack;

import Util.TreeNode;

public class FindModeinBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        int[] result = new int[1];
        Stack<TreeNode> stack = new Stack<>();

        int count = 1;
        int max_count = 0;
        int max_val = 0;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (prev == null) {
                count = 1;
                prev = node;
                max_val = node.val;
            } else if (node.val != prev.val) {
                if (count > max_count) {
                    max_count = count;
                    max_val = prev.val;
                    prev = node;
                    count = 1;
                }
            } else {
                ++count;
            }

            root = node.right;
        }

        result[0] = max_val;
        return result;
    }
}
