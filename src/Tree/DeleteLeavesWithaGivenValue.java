package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，和一个值target，删掉值等于target的叶子节点，如果删掉叶子节点之后的父节点的值也等于target，也要删除父节点
//解法描述:递归

public class DeleteLeavesWithaGivenValue {

  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (root == null) {
      return null;
    }

    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    // 如果父节点变成叶子节点之后并且等于target 也要删除
    if (root.left == null && root.right == null && root.val == target) {
      return null;
    }

    return root;
  }
}
