package DepthFirstSearch;

//题目描述:给定一个二维数组，1代表起点，2代表终点，-1代表obstacle，0代表可以通过，找到所有从1到2的路径，使得路径只经过0的点一次
//解法描述:dfs，0的个数代表路径的长度

public class UniquePaths {

    private int count = 0;

    private void dfs(int i, int j, boolean[][] visited, int[][] grid, int num) {
        if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] || grid[i][j] == -1) {
            return;
        }

        // 找到一条到达2的路径
        if (grid[i][j] == 2) {
            if (num == 0) {
                ++count;
            }
            return;
        }

        visited[i][j] = true;
        dfs(i + 1, j, visited, grid, num - 1);
        dfs(i - 1, j, visited, grid, num - 1);
        dfs(i, j + 1, visited, grid, num - 1);
        dfs(i, j - 1, visited, grid, num - 1);
        visited[i][j] = false;
    }

    public int uniquePathsIII(int[][] grid) {
        int zero = 0;
        int x = 0, y = 0;
        // 找到起点坐标和0的个数
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) {
                    ++zero;
                }

                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[x][y] = true;
        dfs(x + 1, y, visited, grid, zero);
        dfs(x - 1, y, visited, grid, zero);
        dfs(x, y + 1, visited, grid, zero);
        dfs(x, y - 1, visited, grid, zero);

        return count;
    }
}
