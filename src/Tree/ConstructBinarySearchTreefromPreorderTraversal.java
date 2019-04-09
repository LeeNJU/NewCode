package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树的前序遍历，还原二叉搜索树
//解法描述:递归

public class ConstructBinarySearchTreefromPreorderTraversal {

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right || right >= preorder.length || left < 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[left]);
        // 找到右子树的起点下标
        int index = left + 1;
        while (index < preorder.length && index <= right && preorder[index] < root.val) {
            ++index;
        }

        root.right = dfs(preorder, index, right);
        root.left = dfs(preorder, left + 1, index - 1);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }
}
