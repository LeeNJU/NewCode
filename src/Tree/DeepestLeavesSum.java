package Tree;

import Util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个二叉树，找到最深一层的元素的和
//解法描述:层次遍历，记录每一层的和，遍历完最后一层就可以得到最后一层的和
public class DeepestLeavesSum {

  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int sum = 0;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      sum = 0;
      for (int i = 0; i < size; ++i) {
        TreeNode node = queue.poll();
        sum += node.val;

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return sum;
  }
}
