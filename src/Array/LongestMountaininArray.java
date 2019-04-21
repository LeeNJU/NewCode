package Array;

//题目描述:给定一个整数数组，找到一个最长的mountain，返回其长度，例如[2,1,4,7,3,2,5]，最长的mountain子数组是[1,4,7,3,2],返回5
//解法描述:扫描，先找递增的部分，再找递减的部分

public class LongestMountaininArray {

    public int longestMountain(int[] A) {
        int maxLength = 0;
        int i = 1;

        while (i < A.length) {
            // skip重复元素
            if (A[i] == A[i - 1]) {
                ++i;
                continue;
            }

            int increasing = 0, decreasing = 0;

            // 找到递增的序列
            while (i < A.length && A[i - 1] < A[i]) {
                i++;
                increasing++;
            }

            // 找到递减的序列
            while (i < A.length && A[i - 1] > A[i]) {
                i++;
                decreasing++;
            }

            // 二者必须大于0才能保证这是一个mountain
            if (increasing > 0 && decreasing > 0) {
                maxLength = Math.max(maxLength, increasing + decreasing + 1);
            }
        }

        return maxLength;
    }
}
