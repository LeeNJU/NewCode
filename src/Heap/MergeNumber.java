package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//题目描述:给定一个非负整数数组，每次选两个数进行合并，合并a和b的能量为a + b，求最小的能量和，例如Given [1,2,3,4], return 19，合并1 + 2，消耗3，然后合并3 + 3，限号6，最后合并
//        6 + 4，消耗10，总共消耗19
//解法描述:最小堆，合并a + b之后把b + b放入最小堆中，记录合并的能量纸盒

public class MergeNumber {

    public int mergeNumber(int[] numbers) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Arrays.stream(numbers)
                .forEach(number -> queue.add(number));

        int result = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a + b);
            result += a + b;
        }

        return result;
    }
}
