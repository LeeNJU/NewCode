package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到其中所有重复的子树，例如
//         1
//        / \
//       2   3
//      /   / \
//     4   2   4       2
//        /           /
//       4       其中 4   和 4是重复的子树
//解法描述:遍历每一个节点，用先序遍历或者后序遍历表示一个子树

public class FindDuplicateSubtrees {

    private String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        if (root == null) {
            return "#";
        }

        String str = root.val + "," + dfs(root.left, map, list) + "," + dfs(root.right, map, list);
        if (map.getOrDefault(str, 0) == 1) {
            list.add(root);
        }

        // 统计当前子树的个数
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<TreeNode> result = new ArrayList<TreeNode>();
        dfs(root, map, result);
        return result;
    }
}
