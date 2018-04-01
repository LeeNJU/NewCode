package Tree;

import Util.TreeNode;

//思路: 给定一个二叉树，找到最长的路径，使得这条路径的所有元素相同，例如：
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//     路径为5->5->5,返回边的个数2
//     递归，返回以当前节点为开始的路径的最大长度，这是局部解

public class LongestUnivaluePath {

    private int result = 0;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int cur = 0;

        int left_result = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int right_result = root.right != null && root.right.val == root.val ? right + 1 : 0;

        cur = Math.max(left_result, right_result);
        result = Math.max(cur, result);
        result = Math.max(result, left_result + right_result);
        return cur;
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return result;
    }
}
