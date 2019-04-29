package DepthFirstSearch;

//题目描述:给定一个二维数组，只包含true和false，true表示island，false表示sea，求岛的面积大于等于k的个数
//解法描述:dfs

public class NumberofBigIslands {

    private int dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || !grid[i][j]) {
            return 0;
        }

        grid[i][j] = false;
        return dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
    }

    public int numsofIsland(boolean[][] grid, int k) {
        int result = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] && dfs(grid, i, j) >= k) {
                    ++result;
                }
            }
        }

        return result;
    }
}
