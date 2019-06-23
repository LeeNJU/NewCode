package HashTable;

import java.util.Map;
import java.util.TreeMap;

//题目描述:实现my calendar方法，可以允许两个event有重复，但是不允许有3个以上的event有重复
//解法描述:对每一个event进行计数,[start, end)，起始时间点start加1，表示一个event开始，终止时间end减1，表示一个event结束，然后按照时间顺序遍历，count表示当前正在进行的event
//       的数量

public class MyCalendarII {

    private Map<Integer, Integer> map;

    public MyCalendarII() {
        map = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int count = 0;
        for (int key : map.keySet()) {
            // 表示当前正在进行的event的数量
            count += map.get(key);

            if (count == 3) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }

        return true;
    }
}
