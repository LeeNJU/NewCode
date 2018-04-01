package Tree;

import Util.TreeNode;

//题目描述: 给定一个儿茶搜索树和一个数值范围[L, R], 裁剪该树，使得所有元素的值都在[L, R]这个范围， 例如
//          1      返回     1
//         / \               \
//        0   2               2
//解法描述: 递归

public class TrimaBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }

        return root;
    }
}
