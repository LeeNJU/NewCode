package Tree;

import Util.TreeNode;

//题目描述:给定一棵树，如果一个节点的祖父节点的值是偶数，找到所有这样的节点的和
//解法描述:dfs，访问当前节点的时候保存父节点和祖父节点

public class SumofNodeswithEvenValuedGrandparent {

  private int result = 0;

  private void dfs(TreeNode root, TreeNode parent, TreeNode grandParent) {
    if (root == null) {
      return;
    }

    if (grandParent != null && grandParent.val % 2 == 0) {
      result += root.val;
    }

    dfs(root.left, root, parent);
    dfs(root.right, root, parent);
  }

  public int sumEvenGrandparent(TreeNode root) {
    dfs(root, null, null);
    return result;
  }
}
