package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Util.TreeNode;

//题目描述:给定一个二叉树，删除其中的某些节点，这样会产生多个树，返回每个树的根节点，例如root = [1,2,3,4,5,6,7], to_delete = [3,5]，删除3和5，返回[[1,2,null,4],[6],[7]]
//                1
//               / \
//              2   3
//             / \ / \
//            4  5 6  7
//解法描述:dfs遍历每个节点，只有当前节点被删除，才有可能产生新的树，根节点是特殊节点

public class DeleteNodesAndReturnForest {

    private TreeNode dfs(TreeNode node, final Set<Integer> set, List<TreeNode> list) {
        if (node == null) {
            return null;
        }

        if (set.contains(node.val) && node.left != null && !set.contains(node.left.val)) {
            list.add(node.left);
        }

        if (set.contains(node.val) && node.right != null && !set.contains(node.right.val)) {
            list.add(node.right);
        }

        node.left = dfs(node.left, set, list);
        node.right = dfs(node.right, set, list);

        return set.contains(node.val) ? null : node;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Set<Integer> set = Arrays.stream(to_delete)
                .boxed()
                .collect(Collectors.toSet());

        if (root != null && !set.contains(root.val)) {
            list.add(root);
        }

        root = dfs(root, set, list);

        return list;
    }
}
