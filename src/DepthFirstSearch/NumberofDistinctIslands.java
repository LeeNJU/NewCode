package DepthFirstSearch;

import java.util.HashSet;
import java.util.Set;

//题目描述:给定一个只包含0和1的二维数组，找到其中不同的小岛的个数，小岛定义为只包含1的面积，可能会有重复的小岛
//解法描述:dfs，难点在于判断两个岛是否相同，存储每个点的相对坐标，映射成字符串，存在set里面，自动去重

public class NumberofDistinctIslands {

    private void dfs(int i, int j, int x, int y, int[][] grid, boolean[][] visited, StringBuilder island) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != 1) {
            return;
        }

        visited[i][j] = true;
        island.append("_")
                .append(i - x)
                .append("_")
                .append(j - y);
        dfs(i - 1, j, x, y, grid, visited, island);
        dfs(i + 1, j, x, y, grid, visited, island);
        dfs(i, j - 1, x, y, grid, visited, island);
        dfs(i, j + 1, x, y, grid, visited, island);
    }

    public int numberofDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    dfs(i, j, i, j, grid, visited, stringBuilder);
                    set.add(stringBuilder.toString());
                }
            }
        }

        return set.size();
    }
}
