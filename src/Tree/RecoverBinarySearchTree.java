package Tree;

import java.util.Stack;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，其中有两个节点交换了位置，要求恢复这颗二叉搜索树，
//解法描述:在中序遍历中，被调换的两个节点，第一个节点一定是大于后一个节点，第二个节点一定是小于前一个节点，如果需要常数空间，就需要morris遍历
//       需要注意的是，被调换的两个节点是相邻的情况

public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            // 当前节点比前一个节点小
            if (prev != null && cur.val < prev.val) {
                if (node1 == null) {
                    node1 = prev;
                }

                // 注意这里
                node2 = cur;
            }

            prev = cur;
            root = prev.right;
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
