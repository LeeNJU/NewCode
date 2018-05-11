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
}
