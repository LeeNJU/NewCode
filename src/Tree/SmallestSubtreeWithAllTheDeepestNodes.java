package Tree;

import Util.TreeNode;
import javafx.util.Pair;

//题目描述:给定一个二叉树，找到一个节点，使得它的所有子节点都是深度最深的叶子节点，例如
//                  3
//                5    1
//              6   2 0  8
//                 7 4       返回2，因为7和4是最深的叶子节点
//解法描述:递归，dfs返回深度和满足条件的节点

public class SmallestSubtreeWithAllTheDeepestNodes {

    private Pair<Integer, TreeNode> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<Integer, TreeNode>(0, null);
        }

        Pair<Integer, TreeNode> left = dfs(root.left);
        Pair<Integer, TreeNode> right = dfs(root.right);

        // 深度相同，root就是
        if (left.getKey() == right.getKey()) {
            return new Pair<Integer, TreeNode>(left.getKey() + 1, root);
        } else if (left.getKey() < right.getKey()) {
            return new Pair<Integer, TreeNode>(right.getKey() + 1, right.getValue());
        } else {
            return new Pair<Integer, TreeNode>(left.getKey() + 1, left.getValue());
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).getValue();
    }
}
