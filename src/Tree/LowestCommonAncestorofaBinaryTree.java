package Tree;

import Util.TreeNode;
import java.util.HashSet;

//题目描述:给定一个二叉树和两个节点，找到这两个节点的最低的公共父节点
//解法描述:递归，注意，如果左子树递归返回的结果不是nullptr，那么并不代表该结果就是最终的结果，因为左子树包含
//        p或者q中的一个节点的时候，也会返回非nullptr，这时候要看右子树的递归结果

public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    // version 2
    // 每一个节点都有一个parent指向parent node，求lowest common ancestor
    // 保存A节点的所有parent ndoe，然后遍历B节点找到第一个在set中的节点
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        HashSet<TreeNode> set = new HashSet<>();
        while (A != null) {
            set.add(A);
            A = A.parent;
        }

        while (B != null) {
            if (set.contains(B)) {
                return B;
            }

            B = B.parent;
        }

        return null;
    }
}
