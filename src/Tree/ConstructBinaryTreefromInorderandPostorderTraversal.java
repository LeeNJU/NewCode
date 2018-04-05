package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树的中序遍历和后序遍历，生成这个二叉树
//解法描述:递归，后序遍历的最后一个节点就是根节点，然后在中序遍历中找到根节点的下标，确定左右子树的大小，注意下标的运算，然后递归

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    private int getIndex(int[] inorder, int in_first, int in_last, int val) {
        for (int i = in_first; i <= in_last; ++i) {
            if (inorder[i] == val) {
                return i;
            }
        }

        return -1;
    }

    private TreeNode dfs(int[] inorder, int in_first, int in_last, int[] postorder, int post_first, int post_last) {
        if (inorder == null || postorder == null || in_first > in_last || post_first > post_last) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[post_last]);
        int index = getIndex(inorder, in_first, in_last, root.val);
        root.left = dfs(inorder, in_first, index - 1, postorder, post_first, post_first + index - in_first - 1);
        root.right = dfs(inorder, index + 1, in_last, postorder, post_first + index - in_first, post_last - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}
