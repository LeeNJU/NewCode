package Tree;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

//题目描述：给定一个二叉树，输出所有根到叶子节点的路径
//解法描述：dfs深搜

public class BinaryTreePaths {

    private void dfs(TreeNode root, String s, List<String> result) {
        if (root == null) {
            return;
        }

        s += root.val + "->";
        if (root.left == null && root.right == null) {
            result.add(s.substring(0, s.length() - 2));
            return;
        }

        dfs(root.left, s, result);
        dfs(root.right, s, result);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        dfs(root, "", result);
        return result;
    }
}
