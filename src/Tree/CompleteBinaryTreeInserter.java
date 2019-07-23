package Tree;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

//题目描述:设计一种数据结构，保存complete binary tree，完全的二叉树，只有最后一行可能没有填满，其他行都填满了节点，实现以下操作，insert插入一个节点到这个完全二叉树
//        中，并返回父节点的值，get_root返回根节点
//解法描述:关键是要找到父节点，用一个list保存所有的节点(层次遍历)，这样可以利用2*i+1和2*i+2的公式来找到父节点或者子节点

public class CompleteBinaryTreeInserter {

    private List<TreeNode> list;

    public CompleteBinaryTreeInserter(TreeNode root) {
        list = new ArrayList<TreeNode>();
        list.add(root);

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).left != null) {
                list.add(list.get(i).left);
            }

            if (list.get(i).right != null) {
                list.add(list.get(i).right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        list.add(node);
        int n = list.size() - 1;
        if (n % 2 == 0) {
            list.get((n - 1) / 2).right = node;
        } else {
            list.get((n - 1) / 2).left = node;
        }

        return list.get((n - 1) / 2).val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}
