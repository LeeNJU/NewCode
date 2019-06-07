package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

//题目描述:给定一个数组和一个窗口，大小为k，该窗口依次向右移动一步得到一个新的大小为k的窗口，记录每个窗口的
///       最大值
//解法描述:用一个双端队列保存滑动窗口元素，保持队首元素是滑动窗口中的最大值，每加一个元素，与队尾元素比较，如果
//         队尾元素小，删除队尾元素，类似于插入排序，队列中的元素是降序排列。

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            // 保存的是下标
            deque.add(i);

            if (i < k - 1) {
                continue;
            }

            result[i - k + 1] = nums[deque.getFirst()];
            if (deque.getFirst() + k - 1 == i) {
                deque.removeFirst();
            }
        }

        return result;
    }
}
