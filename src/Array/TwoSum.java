package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import Util.TreeNode;

//题目描述：给定一个数组，从中间找出2个数使其加起来等于指定的一个数，例如array={2,9,33,1}找出和等于11的2个数
//解法：用unordered_map存每个数的下标，时间复杂度为O(n)

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }

        return result;
    }

    // 版本2:数组已排序
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] < target) {
                ++left;
            } else {
                --right;
            }
        }

        return result;
    }

    // 版本3:输入是一个二叉搜索树，判断是否有两个节点的和等于k
    private boolean dfs(final TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return dfs(root.left, k, set) || dfs(root.right, k, set);

    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        return dfs(root, k, set);
    }
}
