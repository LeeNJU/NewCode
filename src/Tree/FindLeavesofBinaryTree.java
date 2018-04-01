package Tree;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

//题目描述:给定给一个二叉树，先去除所有叶子节点，得到一个新的二叉树，再去除叶子节点，又得到新的二叉树，直到二叉树为空，例如
//          1
//         / \
//        2   3
//       / \
//      4   5    第一次去掉叶子节点[4, 5, 3],第二次去掉叶子节点[2]，最后去掉叶子节点[1],最后返回[4, 5, 3], [2], [1].
//解法描述: 递归，每一次递归去除一次叶子节点，直到树为空

public class FindLeavesofBinaryTree {

    private TreeNode dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }

        root.left = dfs(root.left, list);
        root.right = dfs(root.right, list);
        return root;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = dfs(root, list);
            result.add(list);
        }

        return result;
    }
}
