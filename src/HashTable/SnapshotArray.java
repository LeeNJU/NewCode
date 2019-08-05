package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

//题目描述:设计一种数据结构，set方法改变元素的值，记录当前的snapshot的版本
//解法描述:用hashmap保存index，treemap保存各个snapshot版本的值

public class SnapshotArray {
    private int snapshotVersion;
    private Map<Integer, TreeMap<Integer, Integer>> map;

    public SnapshotArray(int length) {
        this.snapshotVersion = 0;
        this.map = new HashMap<>();
        IntStream.range(0, length)
                .forEach(index -> map.putIfAbsent(index, new TreeMap<Integer, Integer>()));
    }

    public void set(int index, int val) {
        map.get(index)
                .put(this.snapshotVersion, val);
    }

    public int snap() {
        ++this.snapshotVersion;
        return this.snapshotVersion - 1;
    }

    public int get(int index, int snap_id) {
        Integer floorKey = map.get(index)
                .floorKey(snap_id);
        return floorKey == null ? 0
                : map.get(index)
                        .get(floorKey);
    }
}
