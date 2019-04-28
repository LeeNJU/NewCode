package DynamicProgrammimg;

//题目描述:给定一个数组，找到其中最长的turbulent数组的长度，turbulent的定义是数组上下起伏，大数字，小数字，大数字，小数字，以此类推
//解法描述:dp

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] A) {
        int result = 1;
        int increasingCount = 1;
        int decreasingCount = 1;

        for (int i = 1; i < A.length; ++i) {
            if (i % 2 == 1) {
                if (A[i] > A[i - 1]) {
                    ++increasingCount;
                    decreasingCount = 1;
                } else if (A[i] < A[i - 1]) {
                    increasingCount = 1;
                    ++decreasingCount;
                } else {
                    increasingCount = 1;
                    decreasingCount = 1;
                }
            } else if (A[i] < A[i - 1]) {
                ++increasingCount;
                decreasingCount = 1;
            } else if (A[i] > A[i - 1]) {
                increasingCount = 1;
                ++decreasingCount;
            } else {
                increasingCount = 1;
                decreasingCount = 1;
            }

            result = Math.max(result, increasingCount);
            result = Math.max(result, decreasingCount);
        }

        return result;
    }
}
