package BinarySearch;

//题目描述:给定一个m * n的乘法表，找到第k小的元素，例如m = 3, n = 3, k = 5
//        1	 2	3
//        2	 4	6
//        3	 6	9  第5小的元素是3
//解法描述:二分查找，关键是对于middle，要找到乘法表中比middle小的元素的个数

public class KthSmallestNumberinMultiplicationTable {

    private int count(int mid, int m, int n) {
        int result = 0;
        for (int i = 1; i <= m && i <= mid; ++i) {
            result += i * n <= mid ? n : mid / i;
        }

        return result;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (count(middle, m, n) < k) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }
}
