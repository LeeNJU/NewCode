package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

//题目描述:给定一个二叉树，返回用zigzag方式的层次遍历结果，即偶数层的遍历结果要反转一下
//解法描述:本质是层次遍历，但是加一个变量标记每一层是否需要反转，在每一层的结尾，加入一个nullptr作为层与层之间的分隔符

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (level % 2 == 0) {
                Collections.reverse(list);
            }

            result.add(list);
            ++level;
        }

        return result;
    }
}
