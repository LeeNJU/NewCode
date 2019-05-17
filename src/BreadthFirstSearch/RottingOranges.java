package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个二维数组，只包含0,1和2,2代表腐烂的橘子，1代表正常的橘子，没过一分钟，腐烂的橘子的周围的正常橘子就会变腐烂，求最少需要多少分钟使得所有正常
//       橘子腐烂，如果不能使得所有正常橘子腐烂，返回-1
//解法描述:bfs

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                }

                // 统计正常橘子的个数
                if (grid[i][j] == 1) {
                    ++count;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int i = queue.poll();
                int j = queue.poll();

                int[] dx = { 1, -1, 0, 0 };
                int[] dy = { 0, 0, 1, -1 };

                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
                        continue;
                    }

                    --count;
                    grid[x][y] = 2;
                    queue.add(x);
                    queue.add(y);
                }

                size -= 2;
            }

            // 注意这里，正常橘子腐烂了，才加1
            if (!queue.isEmpty()) {
                ++minutes;
            }
        }

        return count == 0 ? minutes : -1;
    }
}
