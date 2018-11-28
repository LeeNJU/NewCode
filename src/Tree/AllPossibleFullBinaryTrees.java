package Tree;

import java.util.ArrayList;
import java.util.List;

import Util.TreeNode;

//题目描述:给定一个数字n，返回所有可能的二叉树，使得每个节点要么没有子节点，要么有2个子节点
//解法描述:n一定是奇数才能满足条件，对于当前节点，遍历左子树的所有可能性，左子树有1个节点的情况，3个节点的情况，5个节点的情况，同理遍历右子树，得到所有可能的树

public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        // 终止条件
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }

        // 枚举左子树的节点个数，就可以得到右子树的节点个数
        for (int i = 1; i <= N - 1; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(0);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
