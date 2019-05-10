package DepthFirstSearch;

//题目描述:给定一个二维数组，和一个起始地址坐标，相同的元素形成一个岛，把岛的边界的值改成给定的值，边界的点要么是边缘的点，要么相邻的点的值不一样
//解法描述:dfs遍历这个岛的所有点，对于当前遍历的点，判断是不是边界上的点

public class ColoringABorder {

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, int newColor, int oldColor) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != oldColor) {
            return;
        }

        visited[i][j] = true;
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        for (int k = 0; k < dx.length; ++k) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            // 注意这里，相邻的点必须是为访问过的
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != oldColor && !visited[x][y]) {
                grid[i][j] = newColor;
            }
        }

        dfs(grid, i - 1, j, visited, newColor, oldColor);
        dfs(grid, i + 1, j, visited, newColor, oldColor);
        dfs(grid, i, j + 1, visited, newColor, oldColor);
        dfs(grid, i, j - 1, visited, newColor, oldColor);

    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, r0, c0, visited, color, grid[r0][c0]);
        return grid;
    }
}
