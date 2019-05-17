package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，把每个节点的值改成所有大于等于该节点值的和
//解法描述:中序遍历反着来，先遍历右子树，把右子树所有节点的和存到sum，然后更新根节点

public class BinarySearchTreetoGreaterSumTree {

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.right = bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        root.left = bstToGst(root.left);

        return root;
    }
}
