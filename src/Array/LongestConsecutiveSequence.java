package Array;

import java.util.Arrays;
import java.util.HashSet;

//题目描述:给定一个整数数组，找到最长的连续数字的长度，例如{100, 4, 200, 1, 3, 2},最长的连续数字为
//         {1, 2, 3, 4}.长度为4
//解法描述:用hashset表示数组中的元素，遍历数组中的每个数字，分别向左和向右进行扩张（减1和加1），
//         判断其相邻的元素是否在数组中，如果在数组中，则从hashset中删除

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        Arrays.stream(nums)
                .forEach(num -> set.add(num));

        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i])) {
                continue;
            }

            int num = nums[i] + 1;
            int length = 1;
            while (set.contains(num)) {
                ++length;
                set.remove(num);
                ++num;
            }

            num = nums[i] - 1;
            while (set.contains(num)) {
                ++length;
                set.remove(num);
                --num;
            }

            result = Math.max(result, length);
        }

        return result;
    }
}
