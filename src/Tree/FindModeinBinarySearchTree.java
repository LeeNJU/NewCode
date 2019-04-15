package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，找到出现次数最多的元素，可能有多个元素的出现次数都是最多的
//解法描述:遍历二叉树，暴力解

public class FindModeinBinarySearchTree {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int maxFrequency = 0;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(cur.val));

            root = cur.right;
        }

        final int freq = maxFrequency;

        return map.keySet()
                .stream()
                .filter(key -> map.get(key) == freq)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
