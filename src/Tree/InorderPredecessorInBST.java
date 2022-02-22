package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树和一个节点，找到这个节点在中序遍历中的前驱节点
//解法描述:如果p的有左子节点，那么前驱就是左子树的最右边的节点，如果p没有左子节点，遍历整个二叉树，保存可能的前驱结点，root
//        的值比p小，往右子树走，那么root可能是前驱节点，如果root比p大，往左子树走，不更新前驱节点，因为不可能是前驱点
public class InorderPredecessorInBST {

  public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
    // write your code here
    if(root == null) {
      return root;
    }

    TreeNode node = null;

    if(p.left != null) {
      node = p.left;
      while(node.right != null) {
        node = node.right;
      }

      return node;
    }

    while(root != null) {
      if(root.val < p.val) {
        node = root;
        root = root.right;
      } else if(root.val > p.val) {
        root = root.left;
      } else {
        break;
      }
    }

    return node;
  }
}
