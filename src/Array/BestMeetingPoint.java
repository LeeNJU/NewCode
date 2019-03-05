package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//题目描述:给定一个二维矩阵，全部为0或者为1，在矩阵中找到一个点，使得这个点到其他为1的点的距离最短，距离是用
//        曼哈顿距离,|x1 - x2| + |y1 - y2|. 例如
//        1 - 0 - 0 - 0 - 1
//        |   |   |   |   |
//        0 - 0 - 0 - 0 - 0
//        |   |   |   |   |
//        0 - 0 - 1 - 0 - 0  最短距离的点是(0,2)，距离为2 + 2 + 2 = 6
//解法描述:二维上的最短距离点等于一维上的最短距离点。一维上的最短距离为中间那个点到其他点的距离之和。所以分别统计横坐标和
//        纵坐标，找到中间的点分别计算横坐标到中间点的距离之和，计算纵坐标到中间点的距离之和

public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        int index = x.size() / 2;
        int distance = 0;
        for (int num : x) {
            distance += Math.abs(num - x.get(index));
        }

        Collections.sort(y);
        for (int num : y) {
            distance += Math.abs(num - y.get(index));
        }

        return distance;
    }
}
