package UnionFind;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class NumberofDistinctIslandsII {

    private void dfs(int x, int y, int x0, int y0, int[][] grid, List<Pair<Integer, Integer>> list) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return;
        }

        grid[x][y] = -1;
        list.add(new Pair<Integer, Integer>(x - x0, y - y0));
        dfs(x + 1, y, x0, y0, grid, list);
        dfs(x - 1, y, x0, y0, grid, list);
        dfs(x, y - 1, x0, y0, grid, list);
        dfs(x, y + 1, x0, y0, grid, list);
    }

    public int numDistinctIslands2(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
                    dfs(i, j, i, j, grid, list);
                }
            }
        }
    }
}
