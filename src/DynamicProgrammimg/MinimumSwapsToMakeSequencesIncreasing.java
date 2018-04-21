package DynamicProgrammimg;

import java.util.Arrays;

//题目描述:给定两个长度一样的数组A和B，对相同位置的元素可以进行交换或者不交换，swap(A[i],B[i]),求最少的交换次数，使得两个数组都是严格的递增，例如A = [1,3,5,4], B = [1,2,3,7]，
//       交换A[3]和B[3]得到A = [1, 3, 5, 7] and B = [1, 2, 3, 4]，最少交换次数是1
//解法描述:dp, 由于需要知道最后第i个元素是经过交换还是没有交换的，所以需要两个数组来保存状态keep和swap分别表示不交换和交换的情况下，需要的最少步数，

public class MinimumSwapsToMakeSequencesIncreasing {

    public int minSwap(int[] A, int[] B) {
        int length = A.length;
        int[] keep = new int[length];
        int[] swap = new int[length];

        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        keep[0] = 0;
        swap[0] = 1;

        for (int i = 1; i < A.length; ++i) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                keep[i] = keep[i - 1];
                swap[i] = Math.min(swap[i - 1] + 1, swap[i]);
            }

            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                swap[i] = Math.min(keep[i - 1] + 1, swap[i]);
                keep[i] = Math.min(swap[i - 1], keep[i]);
            }
        }

        return Math.min(keep[length - 1], swap[length - 1]);
    }
}
