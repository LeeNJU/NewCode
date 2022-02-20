package Tree;

import Util.TreeNode;
import java.util.HashSet;

//题目描述:给定一个二叉树,根节点是0,左子节点=root.val * 2 + 1,右子节点=root.val * 2 + 2,现在每个节点的值都是-1,请恢复二叉树，并且判断一个值是否存在
//解法描述:dfs恢复二叉树的值，所有的值保存到hashset

public class FindElementsInAContaminatedBinaryTree {

  private HashSet<Integer> set;

  public FindElementsInAContaminatedBinaryTree(TreeNode root) {
    set = new HashSet<>();
    dfs(root, 0);
  }

  public boolean find(int target) {
    return set.contains(target);
  }

  private void dfs(TreeNode root, int value) {
    if (root == null) {
      return;
    }

    root.val = value;
    set.add(value);

    dfs(root.left, value * 2 + 1);
    dfs(root.right, value * 2 + 2);
  }
}
