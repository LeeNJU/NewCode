package DepthFirstSearch;

//题目描述:给定一个二维数组，只包含0和1，找到所有被0包围的1的个数
//解法描述:dfs，从边界上的1出发进行dfs，那么这些1都不是被0包围的，把这些值标为0，然后找到剩下的1的个数

public class NumberofEnclaves {

    private void dfs(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] != 1) {
            return;
        }

        A[i][j] = 0;
        dfs(A, i - 1, j);
        dfs(A, i + 1, j);
        dfs(A, i, j - 1);
        dfs(A, i, j + 1);
    }

    public int numEnclaves(int[][] A) {
        for (int j = 0; j < A[0].length; ++j) {
            if (A[0][j] == 1) {
                dfs(A, 0, j);
            }

            if (A[A.length - 1][j] == 1) {
                dfs(A, A.length - 1, j);
            }
        }

        for (int i = 0; i < A.length; ++i) {
            if (A[i][0] == 1) {
                dfs(A, i, 0);
            }

            if (A[i][A[0].length - 1] == 1) {
                dfs(A, i, A[0].length - 1);
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] == 1) {
                    ++result;
                }
            }
        }

        return result;
    }
}
