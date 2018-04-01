package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到最深一层元素中最左边的一个。
//解法描述:本质是层次遍历，对每一层可以从右到左进行遍历，这样遍历到最后一个元素就是想要的元素

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }
}
