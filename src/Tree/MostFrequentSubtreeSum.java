package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Util.TreeNode;

//题目描述:给定一个二叉树，找到次数最多的子树和，子树和就是每个节点以及所有子树子节点的和，例如   5
//                                                                                 2   -3  所有的子树和是2，-3和4，由于每个只出现一次，所以返回2，-3，4
//解法描述:递归，记录每个子树和的出现次数，以及当前最大次数，最大次数的数字，进行更新

public class MostFrequentSubtreeSum {

    private int maxFrequencey = 0;
    private List<Integer> list = new ArrayList<Integer>();

    private int dfs(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + dfs(root.left, map) + dfs(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (maxFrequencey == map.get(sum)) {
            list.add(sum);
        } else if (maxFrequencey < map.get(sum)) {
            maxFrequencey = map.get(sum);
            list = new ArrayList<Integer>();
            list.add(sum);
        }

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root, new HashMap<Integer, Integer>());
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }

}
