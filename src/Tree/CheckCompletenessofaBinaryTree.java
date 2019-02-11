package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;

//题目描述:判断一个二叉树是不是满二叉树
//解法描述:层次遍历，只有最后一层可以存在null，中间层不能有null

public class CheckCompletenessofaBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // 碰到null
            if (cur == null) {
                end = true;
            } else {
                // 前面已经碰到null，当前节点不是null
                if (end) {
                    return false;
                }

                // 不管是不是null都加入到queue中
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }

        return true;
    }
}
