package Array;

import java.util.PriorityQueue;

//题目描述:有一个连续的数据流，不停的加入元素(未排序)，要求立即返回这些元素的中位数，例如输入1,3,2,立即返回2
//解法描述:要知道元素的顺序才能得到中位数，用两个堆来实现，一个最大堆，一个最小堆，最大堆和最小堆的堆顶元素就是整个数据中
//        的中间元素，最大堆保存前半部分元素，最小堆保存后半部分元素

public class FindMedianfromDataStream {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public FindMedianfromDataStream() {
        small = new PriorityQueue<Integer>();
        large = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // 默认总是放入最大堆，但是先放入最小堆，然后去最小堆堆顶元素放入最大堆
        small.add(num);
        large.add(small.poll());
        // 调节两个堆的大小
        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        return small.size() == large.size() ? (small.peek() + large.peek()) / 2.0 : large.peek();
    }
}
