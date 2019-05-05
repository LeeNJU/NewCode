package UnionFind;

import java.util.ArrayList;
import java.util.List;

import Util.Point;

//题目描述:给定一个二维数组，全是0，表示水，再给一组操作，表示把(x,y)的值设为1，变成island，现在要求出每一个操作之后有多少个island
//解法描述:union-find，关键是把二维坐标映射成一维

public class NumberofIslandsII {

    // 找root
    private int root(int[] array, int i) {
        while (i != array[i]) {
            i = array[i];
        }

        return i;
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // 初始化union-find数组
        int[] arrays = new int[n * m];
        for (int i = 0; i < arrays.length; ++i) {
            arrays[i] = i;
        }

        int[][] matrix = new int[n][m];
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return list;
        }

        for (Point point : operators) {
            if (matrix[point.x][point.y] == 1) {
                list.add(count);
                continue;
            }

            ++count;
            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };
            int root1 = root(arrays, point.x * m + point.y);
            matrix[point.x][point.y] = 1;

            // 上下左右4个点
            for (int i = 0; i < dx.length; ++i) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];

                if (x < 0 || y < 0 || x >= n || y >= m || matrix[x][y] == 0) {
                    continue;
                }

                // 当前节点合并到已有的岛
                int root2 = root(arrays, x * m + y);
                if (root1 != root2) {
                    arrays[root2] = root1;
                    --count;
                }

            }

            list.add(count);
        }

        return list;
    }
}
