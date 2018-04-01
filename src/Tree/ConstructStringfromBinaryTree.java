package Tree;

import Util.TreeNode;

//题目描述: 给定一个二叉树，生成对应的String， 例如
//          1       返回"1(2(4))(3)"
//        /   \
//       2     3
//      /
//     4
//解法描述: 递归

public class ConstructStringfromBinaryTree {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String result = Integer.toString(t.val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left.equals("") && right.equals("")) {
            return result;
        } else if (left.equals("")) {
            return result + "()" + "(" + right + ")";
        } else if (right.equals("")) {
            return result + "(" + left + ")";
        } else {
            return result + "(" + left + ")" + "(" + right + ")";
        }
    }
}
