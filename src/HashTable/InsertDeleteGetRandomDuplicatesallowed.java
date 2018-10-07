package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

//题目描述:设计一种数据结构，使得插入和删除的平均复杂度都是O(1),并且能随机返回其中的元素。
//解法描述:思路一样，用set保存相同元素的下标

public class InsertDeleteGetRandomDuplicatesallowed {

    private List<Integer> list;
    private HashMap<Integer, HashSet<Integer>> map;
    private Random rand;

    public InsertDeleteGetRandomDuplicatesallowed() {
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<Integer, HashSet<Integer>>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        boolean result = map.containsKey(val);
        list.add(val);
        HashSet<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
        set.add(list.size() - 1);
        map.put(val, set);
        return !result;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val)
                .isEmpty()) {
            return false;
        }

        int lastElement = list.get(list.size() - 1);
        if (lastElement == val) {
            map.get(lastElement)
                    .remove(list.size() - 1);
            list.remove(list.size() - 1);
        } else {
            int index = map.get(val)
                    .iterator()
                    .next();
            list.set(index, lastElement);
            map.get(lastElement)
                    .remove(list.size() - 1);
            map.get(lastElement)
                    .add(index);

            map.get(val)
                    .remove(index);
            list.remove(list.size() - 1);
        }

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
