package Tree;

import Util.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//题目描述:给定两个二叉搜索树，返回一个list，里面的元素都是递增排列，例如root1 = [2,1,4], root2 = [1,0,3]，返回[0,1,1,2,3,4]
//解法描述:对两个二叉搜索树同时进行中序遍历

public class AllElementsInTwoBinarySearchTrees {

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> result = new ArrayList<>();

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    while(!stack1.isEmpty() || !stack2.isEmpty() || root1 != null || root2 != null) {

      while(root1 != null) {
        stack1.push(root1);
        root1 = root1.left;
      }

      while(root2 != null) {
        stack2.push(root2);
        root2 = root2.left;
      }

      if (stack1.isEmpty() || (!stack2.isEmpty() && stack1.peek().val > stack2.peek().val)) {
        TreeNode node = stack2.pop();
        result.add(node.val);
        root2 = node.right;
      } else {
        TreeNode node = stack1.pop();
        result.add(node.val);
        root1 = node.right;
      }
    }

    return result;
  }
}