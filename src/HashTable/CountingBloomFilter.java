package HashTable;

import java.util.HashMap;
import java.util.Map;

//题目描述:实现一种数据结构，add方法加入一个string，remove删除一个string，contains是否包含string
//解法描述:简单的hashmap，不必看这题

public class CountingBloomFilter {

    private Map<String, Integer> map;

    public CountingBloomFilter(int k) {
        map = new HashMap<String, Integer>();
    }

    public void add(String word) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    public void remove(String word) {
        map.put(word, map.getOrDefault(word, 1) - 1);
        if (map.get(word) == 0) {
            map.remove(word);
        }
    }

    public boolean contains(String word) {
        return map.containsKey(word);
    }
}
