package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//题目描述:给定一个数组，求出出现次数最多的k个数
//解法描述:map记录元素出现次数，然后用最大堆保存

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Arrays.stream(nums)
                .forEach(num -> hashMap.put(num, hashMap.getOrDefault(num, 0) + 1));

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        hashMap.keySet()
                .stream()
                .forEach(key -> queue.add(new Pair(key, hashMap.get(key))));

        // 注意这里必须按照poll的顺序取出元素，这样的顺序才是堆里面的正确顺序
        return Stream.generate(queue::poll)
                .limit(k)
                .map(pair -> pair.key)
                .collect(Collectors.toList());
    }
}

class Pair implements Comparable<Pair> {
    public int key;
    public int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        return other.value - this.value;
    }
}
