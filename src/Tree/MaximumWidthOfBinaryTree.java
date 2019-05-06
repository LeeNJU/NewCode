package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;
import javafx.util.Pair;

//题目描述:给定一个二叉树，找到最长的宽度，包括中间的null
//解法描述:记录每个节点的下标

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        queue.add(new Pair<TreeNode, Integer>(root, 1));
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Pair<TreeNode, Integer> pair = queue.peek();
            int left = pair.getValue();
            for (int i = 0; i < size; ++i) {
                pair = queue.poll();
                if (pair.getKey().left != null) {
                    queue.add(new Pair<TreeNode, Integer>(pair.getKey().left, pair.getValue() * 2));
                }

                if (pair.getKey().right != null) {
                    queue.add(new Pair<TreeNode, Integer>(pair.getKey().right, pair.getValue() * 2 + 1));
                }

                result = Math.max(result, pair.getValue() - left + 1);
            }
        }

        return result;
    }
}
