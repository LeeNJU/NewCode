package Array;

//题目描述:给定一个矩阵，并且给定一个矩形的坐标，找到矩形的元素之和
//解法描述:类似于presum的思路

public class RangeSumQuery2DImmutable {

    private int[][] sum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            sum = new int[1][1];
            return;
        }

        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < sum.length; ++i) {
            for (int j = 1; j < sum[0].length; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
