package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Util.TreeNode;

//题目描述:给定一个二叉树，以及该二叉树的一个sequence，对于每个节点可以交换左右子节点，使得二叉树的前序遍历和该sequence相同
//解法描述:递归，把sequence中的值与根节点一一匹配

public class FlipBinaryTreeToMatchPreorderTraversal {

    private int index = 0;

    // 递归函数的意义:当前节点是否能够匹配当前的序列
    private boolean dfs(TreeNode root, int[] voyage, List<Integer> list) {
        if (root == null) {
            return true;
        }

        // 当前节点无法匹配
        if (root.val != voyage[index++]) {
            return false;
        }

        // 左子树不匹配，需要交换
        if (root.left != null && root.left.val != voyage[index]) {
            list.add(root.val);
            return dfs(root.right, voyage, list) && dfs(root.left, voyage, list);
        }

        return dfs(root.left, voyage, list) && dfs(root.right, voyage, list);
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<Integer>();
        return dfs(root, voyage, list) ? list : Arrays.asList(-1);
    }
}
