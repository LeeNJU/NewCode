package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//题目描述:设计一种数据结构，实现add和firstUnique方法，add方法加入一个元素，firstUnique返回第一个unique的元素，例如add(1)，add(2)，firstUnique()，add(1)
//       firstUnique(),最后输出[1,2]
//解法描述:list保存元素，map存元素出现次数，index表示当前的firstUnique元素的下标

public class FirstUniqueNumberinDataStreamII {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private int index;

    public FirstUniqueNumberinDataStreamII() {
        this.index = 0;
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Integer>();
    }

    public void add(int num) {
        list.add(num);
        map.put(num, map.getOrDefault(num, 0) + 1);

        while (index < list.size() && map.get(list.get(index)) != 1) {
            ++index;
        }
    }

    public int firstUnique() {
        return list.get(index);
    }
}
