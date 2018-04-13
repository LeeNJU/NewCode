package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

//题目描述:给定一个二叉树，返回每一层的最后一个元素
//解法描述:层次遍历，遍历的时候保存当前访问的元素，那么当遍历完一层的时候，保存的元素就是这一层的最后一个元素

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int value = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                value = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(value);
        }

        return result;
    }
}
