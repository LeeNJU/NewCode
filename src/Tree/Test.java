package Tree;

import Util.TreeNode;

public class Test {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;

        System.out.println(new BinaryTreeTilt().findTilt(node));
    }
}
