package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到两个不同的节点A和B，使得他们的差最大，其中一个节点必须是另一个节点ancestor，返回最大的差值
//解法描述:dfs遍历树，寻找每一条路径，这样可以保证ancestor的关系，然后记录每一条路径中的最大值和最小值去寻找与当前节点的最大差值

public class MaximumDifferenceBetweenNodeandAncestor {

    private int v = Integer.MIN_VALUE;

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }

        v = Math.max(v, Math.abs(root.val - max));
        v = Math.max(v, Math.abs(root.val - min));

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root.right, root.val, root.val);
        dfs(root.left, root.val, root.val);

        return v;
    }
}
