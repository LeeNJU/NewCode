package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，每个节点的值是1到9，找到从根节点到叶子节点路径的个数，是得每个路径上的节点可以构成伪回文序列，例如[1,2,2],[2,3,2]
//       [1,2,3]不是伪回文序列
//解法描述:递归，用一个integer的第一到第九位来记录出现次数

public class PseudoPalindromicPathsInABinaryTree {

  private int dfs(final TreeNode root, int count) {
    if (root == null) {
      return 0;
    }

    // 这里用异或
    count ^= 1 << (root.val - 1);
    if (root.left == null && root.right == null && (count & (count - 1)) == 0) {
      return 1;
    }

    return dfs(root.left, count) + dfs(root.right, count);
  }

  public int pseudoPalindromicPaths (TreeNode root) {
    return dfs(root, 0);
  }
}
