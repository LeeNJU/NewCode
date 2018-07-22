package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，每个节点的值是0或者1，如果一个子树全是0，不包含1，就把子树删除，返回删除之后的二叉树
//       例如      1          返回    1
//              0    1                  1
//            0   0    0
//解法描述:递归
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.right == null && root.left == null) {
            return null;
        }

        return root;
    }
}
