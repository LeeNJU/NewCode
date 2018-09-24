package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个迷宫，元素为0或者1，起点和终点，每次只朝一个方向走，直到碰到边界，然后改变方向，问是否能走到终点，注意终点也必须是边界点
//解法描述:bfs，不同的是，每次计算下一个level的节点时，必须确保是这个方向上的边界点

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start[0]);
        queue.add(start[1]);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int j = queue.poll();

            if (i == destination[0] && j == destination[1]) {
                return true;
            }

            if (visited[i][j]) {
                continue;
            }

            visited[i][j] = true;
            for (int k = 0; k < dx.length; ++k) {
                int x = i + dx[k];
                int y = j + dy[k];

                // 注意这里，找到这个方向的边界点
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += dx[k];
                    y += dy[k];
                }

                queue.add(x - dx[k]);
                queue.add(y - dy[k]);
            }
        }

        return false;
    }
}
