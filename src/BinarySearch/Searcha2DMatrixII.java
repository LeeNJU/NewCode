package BinarySearch;

//题目描述:给定一个二维数组，每一行已排好序，每一列也已经排好序，但是不保证下一行的元素比上一行大，在这个矩阵中查找
//解法描述:从右上角开始查找，如果比target小，那么col向下移动一位，如果比target大,那么row向左移动一位

public class Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
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
