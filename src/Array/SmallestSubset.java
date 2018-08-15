package Array;

import java.util.Arrays;

//题目描述:给定一个数组，找到最小的子集，使得它们的和比剩下元素的和要大，返回子集的大小，例如Given nums = [3, 1, 7, 1], return 1
//解法描述:先排序求和，然后倒序遍历

public class SmallestSubset {

    public int minElements(int[] arr) {
        Arrays.sort(arr);
        int sum = Arrays.stream(arr)
                .sum();

        int rightSum = 0;
        int count = 0;
        for (int i = arr.length - 1; i >= 0; --i) {
            rightSum += arr[i];
            if (rightSum > sum / 2) {
                count = arr.length - i;
                break;
            }
        }

        return count;
    }
}
