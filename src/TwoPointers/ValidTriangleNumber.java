package TwoPointers;

import java.util.Arrays;

//题目描述:给定一个数组，只包含正整数，找到有多少种3个数字的组合，使得它们可以组成三角形的边，例如[2,2,3,4]，总共有3种，[2,2,3],[2,3,4],[2,3,4]
//解法描述:先排序，然后双指针，类似于3Sum的解法，不过要注意的是i必须要倒叙遍历，因为如果i正向遍历，无法判断指针的移动方向

public class ValidTriangleNumber {

    public static int trinumsngleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 1; --i) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    --right;
                } else {
                    ++left;
                }
            }
        }

        return result;
    }
}
