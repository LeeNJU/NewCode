package DepthFirstSearch;

//题目描述:给定一个二维数组，只包含0和1，连续的1组成一个到，岛的面积定义为连续相邻的1的个数，求最大的岛面积
//解法描述:深搜

public class MaxAreaofIsland {

    private boolean[][] visited;

    private int dfs(final int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || visited[i][j] || grid[i][j] != 1) {
            return 0;
        }

        visited[i][j] = true;

        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];

        int maxArea = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }
}
