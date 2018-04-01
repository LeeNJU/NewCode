package Tree;

import Util.TreeNode;

//题目描述:给定两个二叉树，进行合并，
//解法描述: 递归
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode root = new TreeNode(0);
        if (t1 == null) {
            root.val = t2.val;
        } else if (t2 == null) {
            root.val = t1.val;
        } else {
            root.val = t1.val + t2.val;
        }

        // 注意这里，要判断t1和t2是否为null
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return root;
    }
}
