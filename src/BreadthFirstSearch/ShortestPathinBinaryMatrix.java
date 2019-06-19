package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个二维数组，只包含0和1，1表示不能通过，要求从左上角到右下角的最短距离，可以从8个方向移动，包括对角线方向
//解法描述:bfs

public class ShortestPathinBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        queue.add(0);

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size -= 2;
                int i = queue.poll();
                int j = queue.poll();

                if (i == grid.length - 1 && j == grid.length - 1) {
                    return distance + 1;
                }

                int[] dx = { 1, -1, 0, 0, -1, 1, -1, 1 };
                int[] dy = { 0, 0, 1, -1, -1, 1, 1, -1 };
                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 1) {
                        continue;
                    }

                    visited[x][y] = true;
                    queue.add(x);
                    queue.add(y);
                }
            }

            ++distance;
        }

        return -1;
    }
}
