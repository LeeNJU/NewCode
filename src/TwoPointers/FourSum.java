package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//题目描述:给定一个数组和一个值，从中找出四个数字，使得它们的和等于给定的值
//解法描述:先排序，两层for循环，确定头两个数字，然后用两个头尾指针向中间逼近，注意去重，复杂度O(n3)
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        ++left;
                        continue;
                    }

                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        --right;
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        ++left;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }

        return result;
    }

    // 题目描述:给定4个数组，找到tuple(i, j, k, l)使得A[i] + B[j] + C[k] + D[l] = 0，返回这样的tuple的个数
    // 解法描述:遍历A和B，找到两两组合的下标，这个下标同时也是C和D的两两下标，记录每个和的个数
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < C.length; ++i) {
            for (int j = 0; j < D.length; ++j) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                result += map.getOrDefault(-1 * (A[i] + B[j]), 0);
            }
        }

        return result;
    }
}
