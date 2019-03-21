package Tree;

import Util.TreeNode;

//题目描述:给定一个字符串，生成对应的二叉树，例如"-4(2(3)(1))(6(5))",-4是根节点，(2(3)(1))是左子树，(6(5))是右子树
//解法描述:递归，注意下标的运算

public class ConstructBinaryTreefromString {

    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }

        int index = s.indexOf("(");
        if (index == -1) {
            return new TreeNode(Integer.parseInt(s));
        }

        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, index)));
        int count = 0;
        int start = index;
        // 找到左子树
        while (index < s.length()) {
            if (s.charAt(index) == '(') {
                ++count;
            } else if (s.charAt(index) == ')') {
                --count;
            }

            if (count == 0) {
                break;
            }

            ++index;
        }

        root.left = str2tree(s.substring(start + 1, index));
        // 注意这里下标
        root.right = str2tree(s.substring(Math.min(index + 2, s.length() - 1), s.length() - 1));

        return root;
    }
}
