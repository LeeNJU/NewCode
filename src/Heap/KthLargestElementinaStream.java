package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//题目描述:找到第k大的元素
//解法描述:堆，默认生成最小堆

public class KthLargestElementinaStream {

    private int k;
    PriorityQueue<Integer> queue;

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<Integer>();
        Arrays.stream(nums)
                .forEach(num -> queue.add(num));
        while (queue.size() > k) {
            queue.poll();
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}
