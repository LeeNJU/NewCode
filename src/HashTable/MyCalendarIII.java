package HashTable;

import java.util.Map;
import java.util.TreeMap;

//题目描述:实现my calendar方法，可以允许event有重复，返回最大的重复event的个数
//解法描述:和my calendarii类似，保存count的最大值

public class MyCalendarIII {

    private Map<Integer, Integer> map;

    public MyCalendarIII() {
        map = new TreeMap<Integer, Integer>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int count = 0;
        int max = 0;
        for (int key : map.keySet()) {
            count += map.get(key);
            max = Math.max(max, count);
        }

        return max;
    }
}
