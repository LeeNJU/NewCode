package Tree;

import Util.TreeNode;
import Util.UndirectedGraphNode;

//题目描述:给定一个n叉树，序列化成一个二叉树，然后反序列化成原来的n叉树，例如
//                   1                     1
//                /  |  \                /   \ 
//               3   2   4  转换成       3     2
//              / \  |                 /     / \
//             5   6 5                5     5   4
//                                     \
//                                      6
//解法描述:主要是对兄弟节点的处理，根节点的第一个子节点作为左子节点，其他的兄弟节点，全部放到左子节点的右子节点上，这样返回的二叉树肯定没有右子节点

public class EncodeNaryTreetoBinaryTree {

    public UndirectedGraphNode decode(TreeNode root) {
        if (root == null) {
            return null;
        }

        UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(root.val);

        TreeNode cur = root.left;
        while (cur != null) {
            undirectedGraphNode.neighbors.add(decode(cur));
            cur = cur.right;
        }

        return undirectedGraphNode;
    }

    public TreeNode encode(UndirectedGraphNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.label);
        if (root.neighbors.isEmpty()) {
            return node;
        }

        node.left = encode(root.neighbors.get(0));
        TreeNode cur = node.left;
        for (int i = 1; i < root.neighbors.size(); ++i) {
            cur.right = encode(root.neighbors.get(i));
            cur = cur.right;
        }

        return node;
    }
}
