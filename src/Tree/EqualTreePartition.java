package Tree;

import java.util.HashMap;
import java.util.Map;

import Util.TreeNode;

//题目描述:给定一个二叉树，判断是否能够只删除一条边，分成两个子树，并且两个子树的和相同
//解法描述:递归，记录以当前节点为根节点的和以及出现次数，sum必须是偶数

public class EqualTreePartition {

    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int cur = root.val + dfs(root.left, map) + dfs(root.right, map);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }

    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = dfs(root, map);
        // 0是特殊情况
        if (sum == 0) {
            return map.getOrDefault(sum, 0) > 1;
        }

        return sum % 2 == 0 && map.containsKey(sum / 2);
    }
}
