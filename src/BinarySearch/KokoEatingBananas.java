package BinarySearch;

import java.util.Arrays;

//题目描述:给定一个整数数组，和一个值H，每次选中一个数字减去K，如果数字小于K，结果变成0，找到最小的K，使得操作的次数小于等于H，例如piles = [3,6,7,11], H = 8，每次减去4可以满足要求
//解法描述:对K的值进行二分，对于每一个K值，算出需要操作多少次

public class KokoEatingBananas {

    public int leftEatingSpeed(int[] piles, int H) {
        int right = 0, left = 0;
        for (int num : piles) {
            right = Math.max(right, num);
            left = Math.min(left, num);
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int count = Arrays.stream(piles)
                    .map(num -> (int) Math.ceil(num * 1.0 / middle))
                    .sum();

            // 小于H，说明middle的值是有效的
            if (count <= H) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}
