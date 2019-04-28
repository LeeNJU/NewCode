package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//题目描述:给定一个严格递增的数组，找到最长的Fibonacci子序列的长度，例如[1,2,3,4,5,6,7,8]，返回5，因为最长的Fibonacci序列是[1,2,3,5,8]
//解法描述:枚举第一个和第二个元素，然后遍历

public class LengthofLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        Arrays.stream(A)
                .forEach(set::add);

        int length = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                int a = A[i];
                int b = A[j];
                int count = 2;
                while (set.contains(a + b)) {
                    ++count;
                    b = a + b;
                    a = b - a;
                }

                length = Math.max(length, count);
            }
        }

        return length > 2 ? length : 0;
    }
}
