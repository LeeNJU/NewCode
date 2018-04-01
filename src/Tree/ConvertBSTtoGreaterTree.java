package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树，更新每一个节点，使得每一个节点的值是当前的值加上所有比它大的节点的值得和，例如
//          5        返回   18
//        /   \           /   \
//      2     13         20    13
//解法描述:递归，中序遍历的反转形式，用一个变量记录元素从大到下的和

public class ConvertBSTtoGreaterTree {

    int sum = 0;

    private void convert(TreeNode cur) {
        if (cur == null) {
            return;
        }
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

}
