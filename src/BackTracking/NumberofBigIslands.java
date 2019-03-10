package BackTracking;

//题目描述:给定一个二维数组，只包含0和1，相邻的1组成岛屿，求岛屿面积大于k的个数
//解法描述:递归

public class NumberofBigIslands {

    private int dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || !grid[i][j]) {
            return 0;
        }

        grid[i][j] = false;
        return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
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
