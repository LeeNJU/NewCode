package HashTable;

import java.util.HashMap;
import java.util.LinkedHashSet;

//题目描述:实现LFU Cache算法，根据元素的访问频率来删除元素，总是删除访问频率最低的元素
//解法描述:一个hashmap记录key和value，一个hashmap记录key访问的次数，另一个frequency hashmap表示出现次数为k的元素有哪些，注意要保存当前的最小频率更随时更新

public class LFUCache {

    private HashMap<Integer, Integer> values;
    private HashMap<Integer, Integer> count;
    private HashMap<Integer, LinkedHashSet<Integer>> frequency;

    private int capacity;
    private int min_frequency;

    public LFUCache(int capacity) {
        this.min_frequency = 0;
        this.capacity = capacity;
        this.values = new HashMap<Integer, Integer>();
        this.count = new HashMap<Integer, Integer>();
        this.frequency = new HashMap<Integer, LinkedHashSet<Integer>>();
    }

    public int get(int key) {
        if (!count.containsKey(key)) {
            return -1;
        }

        // 更新key的频率
        int freq = count.get(key);
        count.put(key, freq + 1);
        frequency.get(freq)
                .remove(key);

        // 更新min_frequency
        if (min_frequency == freq && frequency.get(freq)
                .isEmpty()) {
            ++min_frequency;
        }

        LinkedHashSet<Integer> linkedHashSet = frequency.getOrDefault(freq + 1, new LinkedHashSet<>());
        linkedHashSet.add(key);
        frequency.put(freq + 1, linkedHashSet);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }

        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        } else if (values.size() == capacity) {
            int num = frequency.get(min_frequency)
                    .iterator()
                    .next();
            frequency.get(min_frequency)
                    .remove(num);
            values.remove(num);
            count.remove(num);
        }

        values.put(key, value);
        count.put(key, 1);
        min_frequency = 1;
        LinkedHashSet<Integer> linkedHashSet = frequency.getOrDefault(1, new LinkedHashSet<>());
        linkedHashSet.add(key);
        frequency.put(1, linkedHashSet);
    }
}
