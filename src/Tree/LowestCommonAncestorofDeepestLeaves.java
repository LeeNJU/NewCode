package Tree;

import Util.TreeNode;
import javafx.util.Pair;

//题目描述:给定一个二叉树，找到深度最深的节点的公共ancestor节点，例如
//                  1
//                2   3
//              4  5         返回2
//解法描述:bottom-up递归,如果左右子节点的深度相同，那么当前节点就是解，如果其中一个子树深度大

public class LowestCommonAncestorofDeepestLeaves {

    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<TreeNode, Integer>(null, 0);
        }

        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);

        if (left.getValue() == right.getValue()) {
            return new Pair<TreeNode, Integer>(root, left.getValue() + 1);
        } else if (left.getValue() < right.getValue()) {
            return new Pair<TreeNode, Integer>(right.getKey(), right.getValue() + 1);
        } else {
            return new Pair<TreeNode, Integer>(left.getKey(), left.getValue() + 1);
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }
}
