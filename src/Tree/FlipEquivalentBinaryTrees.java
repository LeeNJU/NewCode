package Tree;

import Util.TreeNode;

//题目描述:给定两个二叉树，每一个节点可以交换左右子节点，判断两个树经过几步交换之后，是不是相等的
//解法描述:递归

public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        } else {
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        }
    }
}
