package Tree;

import java.util.List;

import Util.TreeNode;

public class Test {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        left.left = four;
        left.right = five;

        List<List<Integer>> result = new FindLeavesofBinaryTree().findLeaves(node);
        System.out.println(result);
    }
}
