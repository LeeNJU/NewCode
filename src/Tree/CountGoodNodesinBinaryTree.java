package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，好到good node的个数，good node就是从根节点到该节点的路径上的值都小于等于该节点
//解法描述:递归

public class CountGoodNodesinBinaryTree {

  private int dfs(TreeNode root, int max) {
    if (root == null) {
      return 0;
    }

    int result = root.val >= max ? 1 : 0;
    max = Math.max(max, root.val);
    return result + dfs(root.left, max) + dfs(root.right, max);
  }
  public int goodNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    return dfs(root.left, root.val) + dfs(root.right, root.val) + 1;
  }
}
