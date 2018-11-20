package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树和一个范围[L, R],找到二叉搜索树种在这个范围之内的元素之和
//解法描述:递归

public class RangeSumofBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}
