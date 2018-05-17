package Array;

//题目描述:给定一个m*n的矩阵，如果某一个元素等于0，那么就把这一行和这一列的所有元素设为0
//解法描述:复杂度m*n,空间复杂度O(1)，先做标记，再设为0. 先扫描第一行和第一组，如果有元素等于0，就做标记，如果
//        一个元素a[i][j]等于0，那么把a[0][j]和a[i][0]设为0作为标记，然后扫描整个矩阵，如果a[0][j]或者
//        a[i][0]等于0，就把a[i][j]设为0

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean rowHasZero = false, columnHasZero = false;
        for (int j = 0; j < m; ++j)// 检测第一行是否存在0
        {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < n; ++i)// 检测第一列是否存在0
        {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 注意这里要从i开始遍历
        for (int j = 1; j < m; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < n; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowHasZero) {
            for (int j = 0; j < m; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (columnHasZero) {
            for (int i = 0; i < n; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
