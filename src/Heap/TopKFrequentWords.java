package Heap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//题目描述:给定一个字符串数组和数字k，找到出现频率最高的前k个字符串
//解法描述:堆

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<String>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));

        map.keySet()
                .stream()
                .forEach(word -> priorityQueue.add(word));
        return Stream.generate(priorityQueue::poll)
                .limit(k)
                .collect(Collectors.toList());
    }
}
