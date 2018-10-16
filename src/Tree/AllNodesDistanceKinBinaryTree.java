package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import Util.TreeNode;

//题目描述:给定一个二叉树，一个target节点和一个K值，找到距离target节点为K的所有节点，
//解法描述:bfs，先建立子节点到父节点的映射，然后bfs

public class AllNodesDistanceKinBinaryTree {

    // 建立子节点到父节点的映射
    private void dfs(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> map) {
        if (root == null || root == target) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        dfs(root.left, target, map);
        dfs(root.right, target, map);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        dfs(root, target, map);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(target);

        while (!queue.isEmpty() && K > 0) {
            --K;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (visited.contains(node)) {
                    continue;
                }

                visited.add(node);
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                }

                if (map.containsKey(node) && map.get(node) != null && !visited.contains(map.get(node))) {
                    queue.add(map.get(node));
                }
            }
        }

        return queue.stream()
                .map(node -> node.val)
                .collect(Collectors.toList());
    }
}
