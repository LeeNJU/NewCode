package Tree;

import java.util.Stack;

import Util.TreeNode;

//题目描述:实现一个二叉搜索树的迭代器，有两个操作，next和hasNext，这两个操作的平均复杂度为O(1),空间复杂度为
//        O(h),其中next函数是指求出以当前节点为根节点的二叉搜索树中最小的元素，即最左边的节点
//解法描述:用一个栈来保存当前节点的所有左子结点，调用next弹出一个节点的时候，如果该节点的右子节点不为空，把
//        右子树的左子结点压入栈中

public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        node = node.right;

        while (node != null) {
            this.stack.add(node);
            node = node.left;
        }

        return result;
    }
}
