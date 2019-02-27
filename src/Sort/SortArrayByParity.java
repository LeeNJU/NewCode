package Sort;

//题目描述:给定一个非负整数数组，长度为偶数，一半元素为奇数，一半元素为偶数，对数组进行排序，使得所有偶数都对应偶数下标，所有奇数都对应奇数下标，例如[4,2,5,7]，返回[4,5,2,7]
//        可以有多种答案
//解法描述:遍历数组，找到第一个不符合条件的偶数和奇数，然后进行交换，然后继续遍历

public class SortArrayByParity {

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, n = A.length;

        while (i < n && j < n) {
            // 找到不符合条件的偶数
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }

            // 找到不符合条件的奇数
            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }

            // 交换
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }

        return A;
    }

}
