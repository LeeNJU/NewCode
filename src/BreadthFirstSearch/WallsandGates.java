package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

//题目描述:给定一个二维数组，0表示gate，-1表示obstacle，INF表示empty room,求每个empty room到最近的gate的距离
//解法描述:从gate出发，广搜，当前节点的位置是x和y，如果要周围的点的值比当前点的值大2，那么需要更新，如果周围点
//        的值比当前点的值小，就不需要更新

public class WallsandGates {

    public void wallsAndGates(int[][] rooms) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int j = queue.poll();

            for (int k = 0; k < dx.length; ++k) {
                int x = i + dx[k];
                int y = j + dy[k];

                // 下标越界或者为obstacle或者距离大于
                if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] == -1 || rooms[x][y] < rooms[i][j]) {
                    continue;
                }

                rooms[x][y] = rooms[i][j] + 1;
                queue.add(x);
                queue.add(y);
            }
        }
    }
}
