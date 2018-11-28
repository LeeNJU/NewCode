package Tree;

import java.util.HashMap;
import java.util.stream.IntStream;

import Util.TreeNode;

//题目描述:给定一个树的先序遍历和后序遍历，返回这个树，可能有多种结果，返回其中一种即可
//解法描述:很容易确定根节点，把后序遍历的元素及下标存到hashmap，确定根节点之后，对于左子树的根节点，找到在后序遍历的下标，得到左子树的长度，从而确定左子树和右子树的区间，然后递归

public class ConstructBinaryTreefromPreorderandPostorderTraversal {

    private TreeNode construdct(HashMap<Integer, Integer> map, int[] pre, int prestart, int preend, int[] post, int poststart, int postend) {
        if (prestart > preend || poststart > postend) {
            return null;
        }

        TreeNode root = new TreeNode(pre[prestart]);
        // 注意这里
        if (prestart == preend) {
            return root;
        }

        int index = map.get(pre[prestart + 1]);
        int length = index - poststart + 1;
        root.left = construdct(map, pre, prestart + 1, prestart + length, post, poststart, index);
        root.right = construdct(map, pre, prestart + length + 1, preend, post, index + 1, postend - 1);
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        IntStream.range(0, post.length)
                .forEach(index -> map.put(post[index], index));

        return construdct(map, pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
}
