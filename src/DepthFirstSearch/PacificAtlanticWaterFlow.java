package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//题目描述:给定一个N*N矩阵代表地势的高度，矩阵的上边和左边代表太平洋，下边和右边代表大西洋，如果下雨，雨水只能
//        流到相同地势或者低一点的地势。在矩阵中找出能够流到两大洋的点的下标
//解法描述:从上边和左边的点出发，深搜找到能流到太平洋的点，然后从右边和下标出发，深搜找到能流到大西洋的点，然后二者求交集

public class PacificAtlanticWaterFlow {

    private void dfs(int i, int j, int[][] matrix, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        if (i - 1 >= 0 && matrix[i - 1][j] >= matrix[i][j]) {
            dfs(i - 1, j, matrix, visited);
        }

        if (i + 1 < matrix.length && matrix[i + 1][j] >= matrix[i][j]) {
            dfs(i + 1, j, matrix, visited);
        }

        if (j - 1 >= 0 && matrix[i][j - 1] >= matrix[i][j]) {
            dfs(i, j - 1, matrix, visited);
        }

        if (j + 1 < matrix[0].length && matrix[i][j + 1] >= matrix[i][j]) {
            dfs(i, j + 1, matrix, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];

        for (int i = 0; i < m; ++i) {
            dfs(0, i, matrix, pacific);
        }

        for (int i = 0; i < n; ++i) {
            dfs(i, 0, matrix, pacific);
        }

        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < m; ++i) {
            dfs(matrix.length - 1, i, matrix, atlantic);
        }

        for (int i = 0; i < n; ++i) {
            dfs(i, matrix[0].length - 1, matrix, atlantic);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }
}
