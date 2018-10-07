package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//题目描述:设计一种数据结构，使得插入和删除的平均复杂度都是O(1),并且能随机返回其中的元素。
//解法描述:vector保存所有元素，map保存元素以及下标，删除的时候，把要删除的元素和最后一个元素交换，然后删除，
//        也就是说总是删除最后一个元素

public class InsertDeleteGetRandom {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    public InsertDeleteGetRandom() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // 跟最后一个元素进行交换，然后默认总是删除最后一个元素
        int index = map.get(val);
        int num = list.get(list.size() - 1);
        map.put(num, index);
        list.set(index, num);

        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
