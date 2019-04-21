package DepthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;

//题目描述:给定一个二维数组，只包含0和1，1可以组成island，最多可以把一个0变成1，求最大的island的面积
//解法描述:先用dfs遍历找到每一个island的大小并编号，求出最大的island面积，然后遍历，遇到0的时候，查看四个方向的island的大小，求出最大值

public class MakingALargeIsland {

    private int dfs(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == color) {
            return 0;
        }

        grid[i][j] = color;
        return 1 + dfs(grid, i + 1, j, color) + dfs(grid, i - 1, j, color) + dfs(grid, i, j - 1, color) + dfs(grid, i, j + 1, color);
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int color = 2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 找到island的大小并且编号涂色
        int maxArea = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    map.put(color, dfs(grid, i, j, color));
                    maxArea = Math.max(maxArea, map.get(color));
                    ++color;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    int[] dx = { 1, -1, 0, 0 };
                    int[] dy = { 0, 0, 1, -1 };

                    // 4个方向有可能是相同的岛，所以用hashset保存island的编号
                    HashSet<Integer> colors = new HashSet<Integer>();
                    for (int k = 0; k < dx.length; ++k) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0 || colors.contains(grid[x][y])) {
                            continue;
                        }

                        area += map.get(grid[x][y]);
                        colors.add(grid[x][y]);
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
