package SlidingWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//题目描述:给定一个数组和一个K值，代表一个长度为K的子数组在移动，找到每个长度为K的子数组的中位数，
//解法描述:sliding window的思路，用最大堆和最小堆来找中位数

public class SlidingWindowMedian {

    private double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < nums.length; ++i) {
            // 注意这里
            if (maxHeap.size() <= minHeap.size()) {
                minHeap.add(nums[i]);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(nums[i]);
                minHeap.add(maxHeap.poll());
            }

            if (i < k - 1) {
                continue;
            }

            list.add(getMedian(minHeap, maxHeap));

            if (!maxHeap.remove(nums[i - k + 1])) {
                minHeap.remove(nums[i - k + 1]);
            }
        }

        return list.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }
}
