package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import javafx.util.Pair;

//题目描述:给定k个有序数组，进行排序
//解法描述:用堆保存k个数组的下标

public class MergeKSortedArrays {

    public int[] mergekSortedArrays(int[][] arrays) {
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> arrays[a.getKey()][a.getValue()] - arrays[b.getKey()][b.getValue()]);
        IntStream.range(0, arrays.length)
                .filter(index -> arrays[index].length > 0)
                .forEach(index -> priorityQueue.add(new Pair<Integer, Integer>(index, 0)));

        List<Integer> list = new ArrayList<Integer>();
        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Integer> pair = priorityQueue.poll();
            list.add(arrays[pair.getKey()][pair.getValue()]);

            if (pair.getValue() + 1 < arrays[pair.getKey()].length) {
                priorityQueue.add(new Pair<Integer, Integer>(pair.getKey(), pair.getValue() + 1));
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
