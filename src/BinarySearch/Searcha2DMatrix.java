package BinarySearch;

//题目描述:给定一个二维数组，每一行已经排好序，且下一行的元素都比上一行的元素大，从这个数组中找到给定的值target，返回
//        true或false
//解法描述:二分法，把二维数组看成一维数组，用二分法查找，middle要换算成二维数组中的坐标

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m - 1, middle;

        while (left <= right) {
            middle = left + (right - left) / 2;
            if (matrix[middle / m][middle % m] == target) {
                return true;
            } else if (matrix[middle / m][middle % m] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }

    // 题目描述:给定一个二维数组，每一行已排好序，每一列也已经排好序，但是不保证下一行的元素比上一行大，在这个矩阵中查找
    // 解法描述:从右上角开始查找，如果比target小，那么col向下移动一位，如果比target大,那么row向左移动一位
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;

        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                ++i;
            } else {
                --j;
            }
        }

        return false;
    }
}
