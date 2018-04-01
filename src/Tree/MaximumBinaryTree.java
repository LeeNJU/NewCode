package Tree;

import Util.TreeNode;

//题目描述: 给定一个没有重复元素的数组，生成二叉树，使得根节点是数组中的最大元素，以最大元素为界，数组分成左右两个小数组，两个小数组的最大元素构成左右子节点，例如[3,2,1,6,0,5]，返回
//          6
//        /   \
//        3     5
//        \    /
//         2  0
//          \
//          1
//解法描述: 找到最大元素的下标，构造根节点，然后递归生成左右子树

public class MaximumBinaryTree {

    // 记录最大元素的下标
    private int maxElement(int[] nums, int left, int right) {
        int index = left;
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }

        return index;
    }

    private TreeNode maximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int index = maxElement(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);

        root.left = maximumBinaryTree(nums, left, index - 1);
        root.right = maximumBinaryTree(nums, index + 1, right);
        return root;

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return maximumBinaryTree(nums, 0, nums.length - 1);
    }
}
