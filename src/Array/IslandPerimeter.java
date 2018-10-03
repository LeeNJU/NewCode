package Array;

//题目描述:给定一个二维数组，只包含0和1，1代表岛，0代表水，求岛的周长
//解法描述:遍历数组，对于每一个点，四个方向，如果这个方向是水，或者是边界，那么周长加1

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    // 边界节点，或者周围是水
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
                        ++perimeter;
                    }
                }
            }
        }

        return perimeter;
    }
}
