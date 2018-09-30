package Math;

//题目描述:给定两个稀疏矩阵，求他们的乘积
//解法描述:扫描A矩阵的每个元素，如果该元素不是0，A[i][j] != 0,那么该元素所在的i行可以和B矩阵的每一列相乘，
//         也就是说，A[i][j]元素可以和B[j][k]相乘，其结果最终会加到C[i][k]元素中。

public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, p = B[0].length;
        int[][] result = new int[m][p];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < p; ++k) {
                        result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return result;
    }
}
