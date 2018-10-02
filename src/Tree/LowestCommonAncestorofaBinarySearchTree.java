package Tree;

import Util.TreeNode;

//题目描述：给定一个二叉树和两个节点，找到这两个节点的最小祖先节点
//解法描述：递归

public class LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q || (root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)) {
            return root;
        }

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
