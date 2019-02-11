package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树，每个节点的值为0到25，代表abcde...z26个字母，求一个从叶子节点到根节点字符串，使得字典序最小
//解法描述:递归

public class SmallestStringStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }

        String left = smallestFromLeaf(root.left);
        String right = smallestFromLeaf(root.right);

        char cur = (char) ('a' + root.val);

        if (root.left == null) {
            return right + cur;
        } else if (root.right == null) {
            return left + cur;
        } else if (left.compareTo(right) <= 0) {
            return left + cur;
        } else {
            return right + cur;
        }
    }
}
