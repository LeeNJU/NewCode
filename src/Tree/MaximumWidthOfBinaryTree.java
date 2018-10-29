package Tree;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到最长的宽度，包括中间的null
//解法描述:记录每个节点的下标

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<Map.Entry<TreeNode, Integer>>();
        queue.add(new AbstractMap.SimpleEntry(root, 1));
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map.Entry<TreeNode, Integer> entry = queue.peek();
            int left = entry.getValue();
            for (int i = 0; i < size; ++i) {
                entry = queue.poll();
                if (entry.getKey().left != null) {
                    queue.add(new AbstractMap.SimpleEntry(entry.getKey().left, entry.getValue() * 2));
                }

                if (entry.getKey().right != null) {
                    queue.add(new AbstractMap.SimpleEntry(entry.getKey().right, entry.getValue() * 2 + 1));
                }

                result = Math.max(result, entry.getValue() - left + 1);
            }
        }

        return result;
    }
}
