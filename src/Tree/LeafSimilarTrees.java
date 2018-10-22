package Tree;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

//题目描述:给定两个二叉树，判断是否有相同的叶子节点，例如
//                  3
//              5        1
//           6     2  9      8
//               7   4           叶子节点的sequence是6，7，4，9，8
//解法描述:递归，找到叶子节点，然后比较

public class LeafSimilarTrees {

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        dfs(root.left, list);
        dfs(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }
}
