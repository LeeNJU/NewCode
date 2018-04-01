package Tree;

import Util.TreeNode;

//题目描述:给定两个二叉树s和t，判断t是不是s的子树
//解法描述:递归，也可以先序遍历，生成String，判断t是不是s的子串

public class SubtreeofAnotherTree {

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null || s.val != t.val) {
            return false;
        } else {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.val == t.val && isSameTree(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
