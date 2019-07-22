package Tree;

import java.util.HashMap;
import java.util.Map;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到路径的个数，使得路径的和等于target，路径必须是从parent到child，例如target = 8
//             10
//            /  \
//           5   -3
//          / \    \
//         3   2   11
//        / \   \
//       3  -2   1
//       满足条件的右3条路径，5->3,  5->2->1, -3->11
//解法描述:利用presum的原理，dfs遍历树的时候，其实是遍历所有根到叶子节点的路径，记录该路径上的presum的次数

public class PathSumIII {

    private int count = 0;

    private void dfs(TreeNode root, int curSum, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        curSum += root.val;
        count += map.getOrDefault(curSum - target, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        dfs(root.left, curSum, target, map);
        dfs(root.right, curSum, target, map);

        map.put(curSum, map.get(curSum) - 1);
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        dfs(root, 0, sum, map);
        return count;
    }
}
