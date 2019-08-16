package Array;

import java.util.HashMap;
import java.util.Map;

//题目描述:实现two sum
//解法描述:hashmap的解法

public class TwoSumIII {

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (int key : map.keySet()) {
            int t = value - key;
            if ((map.containsKey(t) && t != key) || (key == t && map.get(key) > 1)) {
                return true;
            }
        }

        return false;
    }
}
