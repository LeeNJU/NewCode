package Array;

//题目描述:给定一个正数数组和一个范围[L, R],找到所有子数组的个数，使得子数组的最大元素在这个区间[L, R],例如[2, 1, 4, 3]，L = 2, R = 3,满足要求的3个子数组
//       [2], [2, 1], [3]
//解法描述:[left, right]区间表示符合要求的子数组，遍历数组，对于当前元素，考虑以当前元素结尾的子数组是否满足要求

public class NumberofSubarrayswithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int left = -1, right = -1;
        int result = 0;

        for (int i = 0; i < A.length; ++i) {
            // 当前元素比R大，那么子数组的起点必须从left算起
            if (A[i] > R) {
                left = right = i;
                continue;
            }

            if (A[i] >= L) {
                right = i;
            }

            // 如果当前元素小于L，[left, right]区间的子数组依然满足要求
            result += right - left;
        }

        return result;
    }
}
