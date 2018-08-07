package Tree;

import Util.TreeNode;

//题目描述:给定一棵树，找到树的diameter，diameter定义为两个节点的最长路径
//解法描述:递归，返回以当前节点为起始节点的最大长度，由于是局部解，所以用全局变量保存结果

public class DiameterofBinaryTree {

    private int result = 0;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        result = Math.max(result, leftSum + rightSum);

        return Math.max(leftSum, rightSum) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
}
