package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

//题目描述:给定n个点的坐标，找到距离原点最近的k个点
//解法描述:堆

public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        Arrays.stream(points)
                .forEach(a -> queue.add(a));

        int[][] result = new int[Math.min(K, points.length)][2];
        IntStream.range(0, result.length)
                .forEach(index -> result[index] = queue.poll());

        return result;
    }
}
