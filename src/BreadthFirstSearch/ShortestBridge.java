package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个只包含0和1的二维数组，相邻的1组成小岛，一共有2个小岛，求最少经过多少个扩展，使得两个岛相邻
//解法描述:bfs，求最小值的问题，不是dp就是bfs，先把第一个确定，加入bfs的第一层，第一层的元素必须标记为visited，然后依次扩展到下一层

public class ShortestBridge {

    private void dfs(int i, int j, int[][] A, boolean[][] visited, Queue<Integer> queue) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || visited[i][j] || A[i][j] != 1) {
            return;
        }

        visited[i][j] = true;
        queue.add(i);
        queue.add(j);

        dfs(i - 1, j, A, visited, queue);
        dfs(i + 1, j, A, visited, queue);
        dfs(i, j - 1, A, visited, queue);
        dfs(i, j + 1, A, visited, queue);
    }

    public int shortestBridge(int[][] A) {
        int n = A.length, m = A[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Integer> queue = new LinkedList<Integer>();

        boolean found = false;
        for (int i = 0; i < n && !found; ++i) {
            for (int j = 0; j < m && !found; ++j) {
                if (A[i][j] == 1) {
                    found = true;
                    dfs(i, j, A, visited, queue);
                }
            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int a = 0; a < size; a += 2) {
                int i = queue.poll();
                int j = queue.poll();

                for (int k = 0; k < dx.length; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) {
                        continue;
                    }

                    if (A[x][y] == 1) {
                        return step;
                    }

                    visited[x][y] = true;
                    queue.add(x);
                    queue.add(y);
                }
            }

            ++step;
        }

        return -1;
    }
}
