package SegmentTree;

import Util.SegmentTreeNode;

//题目描述:构造线段树，来求区间的和
//解法描述:如下

public class RangeSumQueryMutable {

    private SegmentTreeNode root;

    private SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            node.sum = nums[start];
            return node;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);
        int mid = start + (end - start) / 2;
        node.left = build(nums, start, mid);
        node.right = build(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;

        return node;
    }

    private void update(SegmentTreeNode node, int i, int val) {
        if (node == null || node.start > i || node.end < i) {
            return;
        }

        if (node.start == i && node.end == i) {
            node.sum = val;
            return;
        }

        update(node.left, i, val);
        update(node.right, i, val);

        node.sum = node.left.sum + node.right.sum;
    }

    private int sumRange(SegmentTreeNode node, int i, int j) {
        if (node == null || i > node.end || j < node.start) {
            return 0;
        }

        if (i <= node.start && j >= node.end) {
            return node.sum;
        }

        return sumRange(node.left, i, j) + sumRange(node.right, i, j);
    }

    public RangeSumQueryMutable(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
}
