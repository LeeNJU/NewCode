package Array;

import java.util.Arrays;

//题目描述:给定一个整数数组，move操作可以把任意的元素加1，求最少需要多少个move操作使得每个元素是唯一的，例如[3,2,1,2,1,7]，最少需要6步操作
//解法描述:排序，need表示下一个unique的最小值，总是前一个元素加1

public class MinimumIncrementtoMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }

        Arrays.sort(A);
        int result = 0;
        int need = A[0] + 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] >= need) {
                need = A[i] + 1;
            } else {
                result += need - A[i];
                ++need;
            }
        }

        return result;
    }
}
