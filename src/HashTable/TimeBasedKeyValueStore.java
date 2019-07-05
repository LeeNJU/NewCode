package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//题目描述:设计一种数据结构，满足以下操作，get操作返回小于当前timestamp的最大value
//解法描述:用hashmap存key value，对于不同timestamp的value，用treemap来存

public class TimeBasedKeyValueStore {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treemap = map.getOrDefault(key, new TreeMap<Integer, String>());
        treemap.put(timestamp, value);
        map.put(key, treemap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treemap = map.getOrDefault(key, new TreeMap<Integer, String>());
        Integer time = treemap.floorKey(timestamp);
        return time != null ? treemap.get(time) : "";
    }
}
