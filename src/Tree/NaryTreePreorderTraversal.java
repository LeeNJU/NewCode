package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Util.Node;

//题目描述:给定一个n叉树，求先序遍历
//解法描述:思路和二叉树一样

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            if (node.children == null) {
                continue;
            }

            for (int i = node.children.size() - 1; i >= 0; --i) {
                if (node.children.get(i) != null) {
                    stack.add(node.children.get(i));
                }
            }
        }

        return list;
    }
}
