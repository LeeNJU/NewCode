package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树和一个target值，找到树中与target值最接近的元素
//解法描述:二分遍历

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int result = 0;
        double diff = Double.MAX_VALUE;
        while (root != null) {
            if (Math.abs(target - root.val) < diff) {
                result = root.val;
                diff = Math.abs(target - root.val);
            }

            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return result;
    }

    // 题目描述:给定一个二叉搜索树，找到k个和target距离最近的元素
    // 解法描述:中序遍历二叉搜索树，保存k个数字，比较当前节点与target的距离，因为是有序数字，所有和第一个元素比较
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (list.size() < k) {
                list.add(node.val);
            } else if (Math.abs(node.val - target) < Math.abs(list.get(0) - target)) {
                list.remove(0);
                list.add(node.val);
            }

            root = node.right;
        }

        return list;
    }
}
