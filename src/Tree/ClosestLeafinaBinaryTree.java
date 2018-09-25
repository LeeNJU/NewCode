package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import Util.TreeNode;

//题目描述:给定一个二叉树，和一个k值，找到离该节点最近的叶子节点，路径可以是从子节点到父节点，例如
//             1
//            / \
//           2   3
//          /
//         4
//        /
//       5
//      /
//     6   k=2,3是离2最近的叶子节点
//解法描述:先找到该节点，因为可以从子节点到父节点，所以需要建立子节点到父节点的映射，然后bfs

public class ClosestLeafinaBinaryTree {

    private TreeNode findNode(final TreeNode root, int k, Map<TreeNode, TreeNode> map) {
        if (root == null || root.val == k) {
            return root;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        TreeNode left = findNode(root.left, k, map);
        return left != null ? left : findNode(root.right, k, map);
    }

    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        TreeNode node = findNode(root, k, map);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (set.contains(node)) {
                continue;
            }

            set.add(node);
            if (node.left == null && node.right == null) {
                return node.val;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            if (map.containsKey(node)) {
                queue.add(map.get(node));
            }
        }

        return -1;
    }
}
