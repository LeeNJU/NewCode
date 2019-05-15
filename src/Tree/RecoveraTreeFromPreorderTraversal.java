package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉树的先序遍历，对于每一个节点，先输出D个-，D是当前节点的深度，然后输出节点的值，例如"1-2--3--4-5--6--7"，1是根节点，深度是0，所以没有-,
//       2的深度是1
//解法描述:递归，用一个全局的下标index表示当前解析的位置

public class RecoveraTreeFromPreorderTraversal {

    private int index = 0;

    private TreeNode dfs(String s, int depth) {
        int numOfDash = 0;
        // 找到当前-的个数
        while (index + numOfDash < s.length() && s.charAt(index + numOfDash) == '-') {
            ++numOfDash;
        }

        if (numOfDash < depth) {
            return null;
        }

        int next = index + numOfDash;
        // 得到根节点的值
        while (next < s.length() && Character.isDigit(s.charAt(next))) {
            ++next;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s.substring(index + numOfDash, next)));
        index = next;

        root.left = dfs(s, depth + 1);
        root.right = dfs(s, depth + 1);
        return root;
    }

    public TreeNode recoverFromPreorder(String S) {
        return dfs(S, 0);
    }
}
