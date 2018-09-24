package Tree;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

//题目描述:给定一个二叉树和一个值sum，找到所有从根节点到叶子节点的路径，使得路径的和等于sum
//解法描述:递归，注意java的list是传引用，递归返回时，要删除当前加入到list中的节点

public class PathSum {

    void dfs(TreeNode root, List<Integer> list, int sum, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        dfs(root.left, list, sum - root.val, result);
        dfs(root.right, list, sum - root.val, result);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        dfs(root, list, sum, result);
        return result;
    }

    // 版本2:只需要判断是否存在这样的一条路径
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
