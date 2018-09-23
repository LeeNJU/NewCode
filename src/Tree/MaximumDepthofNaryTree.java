package Tree;

import Util.Node;

//题目描述:给定一个n叉树，找到最大深度
//解法描述:递归

public class MaximumDepthofNaryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children == null) {
            return 1;
        }

        int depth = root.children.stream()
                .map(node -> maxDepth(node))
                .max(Integer::compareTo)
                .orElse(0);
        return depth + 1;
    }
}
