package DynamicProgrammimg;

//题目描述:给定一个数组，找到其中最长的turbulent数组的长度，turbulent的定义是数组上下起伏，大数字，小数字，大数字，小数字，以此类推
//解法描述:dp, increasing表示以当前元素结尾，并且A[i] > A[i - 1]的最大长度，decreasing表示以当前元素结尾，并且A[i] < A[i - 1]的最大长度

public class LongestTurbulentSubarray {

    public int maxTurbulenceSize(int[] A) {
        int increasing = 1, decreasing = 1, result = 1;

        for (int i = 1; i < A.length; ++i) {
            if (A[i] < A[i - 1]) {
                decreasing = increasing + 1;
                increasing = 1;
            } else if (A[i] > A[i - 1]) {
                increasing = decreasing + 1;
                decreasing = 1;
            } else {
                increasing = 1;
                decreasing = 1;
            }

            result = Math.max(result, Math.max(decreasing, increasing));
        }

        return result;
    }
}
