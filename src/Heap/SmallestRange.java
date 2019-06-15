package Heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//题目描述:给定k个已经排好序的数组，找到最小的range，使得每个数组都至少有一个元素包含在这个区间之内，例如[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]，返回
//       [20,24],第一个数组中的24，第二个数组中的20，第三个数组中22在这个区间里
//解法描述:类似于merge k sorted array的思路，不同的是，queue的大小必须是k，才能保证每个数组都至少有一个元素在区间之内，区间就是queue里面元素的最大和最小值，不断
//       更新这个区间

public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> nums.get(a[0])
                .get(a[1])));

        // max表示queue里的最大元素
        int start = 0, end = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); ++i) {
            queue.add(new int[] { i, 0 });
            max = Math.max(max, nums.get(i)
                    .get(0));
        }

        while (queue.size() == nums.size()) {
            int[] array = queue.poll();
            int row = array[0];
            int col = array[1];

            // 遇到更小的区间，就更新
            if (end - start > max - nums.get(row)
                    .get(col)) {
                start = nums.get(row)
                        .get(col);
                end = max;
            }

            // max始终表示queue里面的最大元素
            if (col + 1 < nums.get(row)
                    .size()) {
                queue.add(new int[] { row, col + 1 });
                max = Math.max(max, nums.get(row)
                        .get(col + 1));
            }
        }

        return new int[] { start, end };
    }
}
