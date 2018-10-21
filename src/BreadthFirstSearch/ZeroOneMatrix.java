package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个二维矩阵，只包含0和其他数字，对于每一个数字，找到最近0的距离
//解法描述:bfs，注意把非0元素初始化成Integer.MAX_VALUE,类似于walls and gate

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == 0) {
                    queue.add(i);
                    queue.add(j);
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int j = queue.poll();

            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };
            for (int k = 0; k < dx.length; ++k) {
                int x = i + dx[k];
                int y = j + dy[k];

                // 这里相当于去重
                if (x < 0 || y < 0 || x >= n || y >= m || matrix[i][j] + 1 >= matrix[x][y]) {
                    continue;
                }

                matrix[x][y] = matrix[i][j] + 1;
                queue.add(x);
                queue.add(y);
            }
        }

        return matrix;
    }
}
