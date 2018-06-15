package Tree;

import Util.TreeNode;

//题目描述: 给定一个二叉树，每个节点要么没有子节点，要么一定有两个子节点，如果有两个子节点，那么当前节点的值就是子节点值得最小值，找到这个树种倒数第二小的元素，如果没有，返回-1,例如
//              2
//             / \
//            2   5
//               / \
//              5   7
//        返回5
//解法描述:递归，保存最小和第二小的元素，子节点元素必须必第二小元素小才继续遍历

public class SecondMinimumNodeInaBinaryTree {

    private long first_smallest = Long.MAX_VALUE;
    private long second_smallest = Long.MAX_VALUE;

    private void update(int val) {
        if (val < first_smallest) {
            second_smallest = first_smallest;
            first_smallest = val;
        }

        if (val > first_smallest && val < second_smallest) {
            second_smallest = val;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        update(root.val);
        if (root.left != null && root.left.val < second_smallest) {
            dfs(root.left);
        }

        if (root.right != null && root.right.val < second_smallest) {
            dfs(root.right);
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return second_smallest == Long.MAX_VALUE ? -1 : (int) second_smallest;
    }
}
