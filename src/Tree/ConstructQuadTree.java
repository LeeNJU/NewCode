package Tree;

import Util.QuadTreeNode;

//题目描述:构建QuadTree
//解法描述:递归

public class ConstructQuadTree {

    private QuadTreeNode dfs(int r1, int c1, int r2, int c2, int[][] grid) {
        if (r1 > r2 || c1 > c2) {
            return null;
        }

        boolean isLeaf = true;
        int value = grid[r1][c1];
        for (int i = r1; i <= r2; ++i) {
            for (int j = c1; j <= c2; ++j) {
                if (grid[i][j] != value) {
                    isLeaf = false;
                    break;
                }
            }
        }

        if (isLeaf) {
            return new QuadTreeNode(value == 1, true, null, null, null, null);
        }

        int row = r1 + (r2 - r1) / 2;
        int col = c1 + (c2 - c1) / 2;
        return new QuadTreeNode(false, false, dfs(r1, c1, row, col, grid), // top left
                dfs(r1, col + 1, row, c2, grid), // top right
                dfs(row + 1, c1, r2, col, grid), // bottom left
                dfs(row + 1, col + 1, r2, c2, grid));// bottom right
    }

    public QuadTreeNode construct(int[][] grid) {
        return dfs(0, 0, grid.length - 1, grid[0].length - 1, grid);
    }
}
