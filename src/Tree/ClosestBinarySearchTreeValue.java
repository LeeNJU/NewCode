package Tree;

import Util.TreeNode;

//题目描述:给定一个二叉搜索树和一个target值，找到树中与target值最接近的元素
//解法描述:二分遍历

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int result = 0;
        double diff = Double.MAX_VALUE;
        while (root != null) {
            if (Math.abs(target - root.val) < diff) {
                result = root.val;
                diff = Math.abs(target - root.val);
            }

            if (root.val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return result;
    }
}
