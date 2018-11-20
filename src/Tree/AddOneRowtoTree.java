package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;

//题目描述:给定一个二叉树，一个值v和深度d，在树的第d层添加一层值为v的节点
//解法描述:bfs，找到d - 1层，然后每个节点添加

public class AddOneRowtoTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        --d;
        while (!queue.isEmpty()) {
            if (d == 1) {
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            --d;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;

            TreeNode n = new TreeNode(v);
            node.left = n;
            if (left != null) {
                n.left = left;
            }

            n = new TreeNode(v);
            node.right = n;
            if (right != null) {
                n.right = right;
            }
        }

        return root;
    }
}
